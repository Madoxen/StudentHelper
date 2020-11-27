package com.example.studenthelper.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.studenthelper.R
import com.example.studenthelper.VM.Factory.TeacherViewModelFactory
import com.example.studenthelper.VM.TeacherListViewModel
import com.example.studenthelper.VM.TeacherViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton

class TeacherViewFragment : Fragment() {

    private lateinit var viewModel: TeacherViewModel



    companion object {
        fun newInstance() = TeacherViewFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.teacher_view_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val t = ViewModelProvider(requireActivity()).get(TeacherListViewModel::class.java).chosenTeacher!! //get teacher instance from previous viewmodel
        viewModel = ViewModelProvider(requireActivity(), TeacherViewModelFactory(requireActivity().application, t)).get(TeacherViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<FloatingActionButton>(R.id.addCourse_floatingActionButton)
            .setOnClickListener { view ->
                view.findNavController()
                    .navigate(R.id.action_teacherViewFragment_to_addExistingCourseFragment)
            }




    }

}