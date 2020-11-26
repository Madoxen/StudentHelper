package com.example.studenthelper

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.studenthelper.VM.CourseViewModel
import com.example.studenthelper.VM.TeacherListViewModel

class TeacherListFragment : Fragment() {

    companion object {
        fun newInstance() = TeacherListFragment()
    }

    private lateinit var viewModel: TeacherListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.teacher_list_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(TeacherListViewModel::class.java)
        // TODO: Use the ViewModel
    }
}