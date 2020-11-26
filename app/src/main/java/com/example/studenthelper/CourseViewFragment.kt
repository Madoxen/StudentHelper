package com.example.studenthelper

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.studenthelper.VM.CourseViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton

class CourseViewFragment : Fragment() {

    companion object {
        @JvmStatic
        fun newInstance() = CourseViewFragment()
    }

    private lateinit var viewModel: CourseViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.course_view_fragment, container, false)


        return v
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<FloatingActionButton>(R.id.addStudent_floatingActionButton)
            .setOnClickListener { view ->
                view.findNavController()
                    .navigate(R.id.action_courseViewFragment_to_addStudentFragment)
            }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(CourseViewModel::class.java)
        // TODO: Use the ViewModel
    }

}