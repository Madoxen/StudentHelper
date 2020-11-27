package com.example.studenthelper.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.observe
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.studenthelper.R
import com.example.studenthelper.VM.CourseListViewModel
import com.example.studenthelper.VM.TeacherListViewModel
import com.example.studenthelper.view.Adapter.CourseListAdapter
import com.example.studenthelper.view.Adapter.TeacherListAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton

class CourseListFragment : Fragment() {

    companion object {
        fun newInstance() = CourseListFragment()
    }

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: CourseListAdapter
    private lateinit var viewManager: LinearLayoutManager
    private lateinit var viewModel: CourseListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.course_list_fragment, container, false)
        recyclerView = v.findViewById<RecyclerView>(R.id.allCourses_RecyclerView)
        return v;
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(CourseListViewModel::class.java)

        viewManager = LinearLayoutManager(this.context)
        viewAdapter = CourseListAdapter(
            viewModel.courses
        )




        recyclerView.apply {
            // use this setting to improve performance if you know that changes
            // in content do not change the layout size of the RecyclerView
            setHasFixedSize(true)
            // use a linear layout manager
            layoutManager = viewManager
            // specify an viewAdapter (see also next example)
            adapter = viewAdapter
        }

        viewModel.courses.observe(viewLifecycleOwner) {
            viewAdapter.notifyDataSetChanged();
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}