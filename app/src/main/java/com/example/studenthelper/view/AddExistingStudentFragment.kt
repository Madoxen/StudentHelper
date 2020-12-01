package com.example.studenthelper.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.studenthelper.R
import com.example.studenthelper.VM.CourseViewModel
import com.example.studenthelper.view.Adapter.CourseListAdapter

class AddExistingStudentFragment : Fragment() {

    private val viewModel: CourseViewModel by activityViewModels()
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: CourseListAdapter
    private lateinit var viewManager: LinearLayoutManager

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val v = inflater.inflate(R.layout.fragment_add_existing_student, container, false)
        recyclerView = v.findViewById(R.id.existingStudentsList_RecyclerView)
        return v
    }

}