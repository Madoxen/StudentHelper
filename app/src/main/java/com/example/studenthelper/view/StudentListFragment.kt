package com.example.studenthelper.view

import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.studenthelper.R
import com.example.studenthelper.VM.StudentListViewModel
import com.example.studenthelper.view.Adapter.CourseListAdapter
import com.example.studenthelper.view.Adapter.StudentListAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton

class StudentListFragment : Fragment() {

    companion object {
        fun newInstance() = StudentListFragment()
    }

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: StudentListAdapter
    private val viewModel: StudentListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.student_list_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewManager = LinearLayoutManager(this.context)
        recyclerView = view.findViewById(R.id.allStudents_recyclerView)
        viewAdapter = StudentListAdapter(
            viewModel.students
        )
        {
            //delete handler
            viewModel.removeStudent(it);
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

        viewModel.students.observe(viewLifecycleOwner) {
            viewAdapter.notifyDataSetChanged();
        }

        view.findViewById<FloatingActionButton>(R.id.addStudent_floatingActionButton).setOnClickListener {
            view.findNavController().navigate(R.id.action_studentListFragment_to_addStudentFragment)
        }
    }


}