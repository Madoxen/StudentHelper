package com.example.studenthelper.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.example.studenthelper.R
import com.example.studenthelper.VM.CourseListViewModel
import com.example.studenthelper.VM.CourseViewModel
import com.example.studenthelper.VM.Factory.CourseViewModelFactory
import com.example.studenthelper.model.Course
import com.google.android.material.floatingactionbutton.FloatingActionButton

class CourseViewFragment : Fragment() {

    companion object {
        @JvmStatic
        fun newInstance() = CourseViewFragment()
    }

    private val viewModel: CourseViewModel by viewModels {
        CourseViewModelFactory(requireActivity().application, arguments?.get("course") as Course)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.course_view_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<FloatingActionButton>(R.id.addStudent_floatingActionButton)
            .setOnClickListener { view ->
                view.findNavController()
                    .navigate(R.id.action_courseViewFragment_to_addExistingStudentFragment)
            }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        // TODO: Use the ViewModel
    }

}