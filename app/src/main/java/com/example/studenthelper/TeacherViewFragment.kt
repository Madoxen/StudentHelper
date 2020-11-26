package com.example.studenthelper

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.studenthelper.VM.CourseViewModel
import com.example.studenthelper.VM.TeacherViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton

class TeacherViewFragment : Fragment() {


    companion object {
        fun newInstance() = TeacherViewFragment()
    }

    private lateinit var viewModel: TeacherViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.teacher_view_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(TeacherViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<FloatingActionButton>(R.id.addCourse_floatingActionButton)
            .setOnClickListener { view ->
                view.findNavController()
                    .navigate(R.id.action_teacherViewFragment_to_addCourseFragment)
            }
    }

}