package com.example.studenthelper.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.observe
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.studenthelper.R
import com.example.studenthelper.VM.StudentListViewModel
import com.example.studenthelper.view.Adapter.StudentListAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton

class StudentListFragment : Fragment() {

    companion object {
        fun newInstance() = StudentListFragment()
    }

    private lateinit var recyclerView: RecyclerView
    private lateinit var fab: FloatingActionButton
    private lateinit var viewAdapter: StudentListAdapter
    private lateinit var navController: NavController
    private val viewModel: StudentListViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.student_list_fragment, container, false)
        recyclerView = v.findViewById(R.id.allStudents_recyclerView)
        fab = v.findViewById<FloatingActionButton>(R.id.addStudent_floatingActionButton)
        return v
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val linearLayoutManager = LinearLayoutManager(this.context)
        navController = view.findNavController()

        viewAdapter = StudentListAdapter(
            viewModel.students
        )
        {
            //delete handler
            viewModel.removeStudent(it)
        }

        recyclerView.apply {
            // use this setting to improve performance if you know that changes
            // in content do not change the layout size of the RecyclerView
            setHasFixedSize(true)
            // use a linear layout manager
            layoutManager = linearLayoutManager
            // specify an viewAdapter (see also next example)
            adapter = viewAdapter
        }

        viewModel.students.observe(viewLifecycleOwner) {
            viewAdapter.notifyDataSetChanged()
        }

        fab
            .setOnClickListener {
                navController
                    .navigate(R.id.action_studentListFragment_to_addStudentFragment)
            }
    }


}