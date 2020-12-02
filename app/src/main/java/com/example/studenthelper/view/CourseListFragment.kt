package com.example.studenthelper.view

import android.os.Bundle
import android.view.*
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.observe
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.recyclerview.selection.SelectionPredicates
import androidx.recyclerview.selection.SelectionTracker
import androidx.recyclerview.selection.StableIdKeyProvider
import androidx.recyclerview.selection.StorageStrategy
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.studenthelper.R
import com.example.studenthelper.VM.CourseListViewModel
import com.example.studenthelper.view.Adapter.CourseListAdapter
import com.example.studenthelper.view.Base.RVLookup
import com.google.android.material.floatingactionbutton.FloatingActionButton

class CourseListFragment : Fragment() {

    companion object {
        fun newInstance() = CourseListFragment()
    }

    private lateinit var recyclerView: RecyclerView
    private lateinit var fab: FloatingActionButton
    private lateinit var viewAdapter: CourseListAdapter
    private lateinit var viewManager: LinearLayoutManager
    private lateinit var navController: NavController
    private lateinit var tracker: SelectionTracker<Long>
    private val viewModel: CourseListViewModel by activityViewModels()


    private var actionMode: ActionMode? = null
    private val actionModeCallback = object : ActionMode.Callback {
        // Called when the action mode is created; startActionMode() was called
        override fun onCreateActionMode(mode: ActionMode, menu: Menu): Boolean {
            // Inflate a menu resource providing context menu items
            val inflater: MenuInflater = mode.menuInflater
            inflater.inflate(R.menu.list_context_action_menu, menu)
            return true
        }

        // Called each time the action mode is shown. Always called after onCreateActionMode, but
        // may be called multiple times if the mode is invalidated.
        override fun onPrepareActionMode(mode: ActionMode, menu: Menu): Boolean {
            return false // Return false if nothing is done
        }

        // Called when the user selects a contextual menu item
        override fun onActionItemClicked(mode: ActionMode, item: MenuItem): Boolean {
            return when (item.itemId) {
                R.id.menu_deleteItems -> {
                    tracker.selection.mapNotNull { x -> viewAdapter.courses.value?.get(x.toInt()) }
                        .forEach { viewModel.removeCourse(it) }
                    tracker.clearSelection()
                    mode.finish() // Action picked, so close the CAB
                    true
                }
                else -> false
            }
        }

        // Called when the user exits the action mode
        override fun onDestroyActionMode(mode: ActionMode) {
            actionMode = null
            tracker.clearSelection()
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.course_list_fragment, container, false)
        recyclerView = v.findViewById(R.id.allCourses_RecyclerView)
        fab = v.findViewById(R.id.addCourse_floatingActionButton)
        return v
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = view.findNavController()
        viewManager = LinearLayoutManager(this.context)
        viewAdapter = CourseListAdapter(
            viewModel.courses
        ) {
            //select handler
            val bundle = bundleOf("courseID" to it.ID)
            navController
                .navigate(R.id.action_courseListFragment_to_courseViewFragment, bundle)
        }

        recyclerView.apply {
            // use this setting to improve performance if you know that changes
            // in content do not change the layout size of the RecyclerView
            setHasFixedSize(true)
            // use a linear layout manager
            layoutManager = viewManager
            // specify an viewAdapter (see also next example)
            adapter = viewAdapter
        }


        tracker = SelectionTracker.Builder<Long>(
            "selection-1",
            recyclerView,
            StableIdKeyProvider(recyclerView),
            RVLookup<CourseListAdapter.CourseViewHolder, Long>(recyclerView),
            StorageStrategy.createLongStorage()
        ).withSelectionPredicate(
            SelectionPredicates.createSelectAnything()
        ).build()

        tracker.addObserver(object : SelectionTracker.SelectionObserver<Any?>() {

            override fun onSelectionChanged() {
                super.onSelectionChanged()
                if (tracker.hasSelection() && actionMode == null) { //when we select something for the first time
                    actionMode = activity?.startActionMode(actionModeCallback)
                } else if (!tracker.hasSelection() && actionMode != null) { //when we deselected everything
                    actionMode!!.finish()
                    actionMode = null
                } else { //when we still have some selection
                    /* setMenuItemTitle(selectionTracker.getSelection().size())*/
                }
            }
        })

        viewAdapter.tracker = tracker

        viewModel.courses.observe(viewLifecycleOwner) {
            viewAdapter.notifyDataSetChanged()
        }

        fab.setOnClickListener {
            navController.navigate(R.id.action_courseListFragment_to_addCourseFragment)
        }

        if (savedInstanceState != null)
            tracker.onRestoreInstanceState(savedInstanceState)

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        tracker.onSaveInstanceState(outState)
    }


}