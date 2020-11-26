package com.example.studenthelper

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.studenthelper.VM.CourseViewModel

class CourseViewFragment : Fragment() {

    companion object {
        fun newInstance() = CourseViewFragment()
    }

    private lateinit var viewModel: CourseViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.course_view_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(CourseViewModel::class.java)
        // TODO: Use the ViewModel
    }

}