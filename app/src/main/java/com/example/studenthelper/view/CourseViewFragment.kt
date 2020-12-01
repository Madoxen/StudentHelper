package com.example.studenthelper.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.example.studenthelper.R
import com.example.studenthelper.VM.CourseViewModel
import com.example.studenthelper.VM.Factory.CourseViewModelFactory
import com.google.android.material.floatingactionbutton.FloatingActionButton

class CourseViewFragment : Fragment() {

    companion object {
        @JvmStatic
        fun newInstance() = CourseViewFragment()
    }

    private val viewModel: CourseViewModel by activityViewModels {
        CourseViewModelFactory(requireActivity().application, arguments?.get("courseID") as Long)
    }

    private lateinit var fab: FloatingActionButton
    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.course_view_fragment, container, false)
        fab = v.findViewById<FloatingActionButton>(R.id.addStudent_floatingActionButton)
        return v
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = view.findNavController()
        fab.setOnClickListener {
            navController
                .navigate(R.id.action_courseViewFragment_to_addExistingStudentFragment)
        }
    }
}