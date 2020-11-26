package com.example.studenthelper

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.studenthelper.VM.TeacherListViewModel
import com.example.studenthelper.view.TeacherListAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton

class TeacherListFragment : Fragment() {

    private lateinit var viewModel: TeacherListViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    companion object {
        fun newInstance() = TeacherListFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.teacher_list_fragment, container, false)
        recyclerView = v.findViewById<RecyclerView>(R.id.teachers_recyclerView)
        return v;
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel =
            ViewModelProvider(requireActivity()).get(TeacherListViewModel::class.java) //This view model is bound to activity


        viewManager = LinearLayoutManager(this.context)
        viewAdapter  = TeacherListAdapter(viewModel.teachers) {/*TODO: deletion callback*/};


        recyclerView.apply {
            // use this setting to improve performance if you know that changes
            // in content do not change the layout size of the RecyclerView
            setHasFixedSize(true)
            // use a linear layout manager
            layoutManager = viewManager
            // specify an viewAdapter (see also next example)
            adapter = viewAdapter
        }

        viewModel.teachers.observe(viewLifecycleOwner) {
                viewAdapter.notifyDataSetChanged();
        }



    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<FloatingActionButton>(R.id.addTeacher_floatingActionButton)
            .setOnClickListener { view ->
                view.findNavController()
                    .navigate(R.id.action_teacherListFragment_to_addTeacherFragment)
            }
    }

}