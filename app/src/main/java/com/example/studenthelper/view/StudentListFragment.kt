package com.example.studenthelper.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.studenthelper.R
import com.example.studenthelper.VM.StudentListViewModel

class StudentListFragment : Fragment() {

    companion object {
        fun newInstance() = StudentListFragment()
    }

    private lateinit var viewModel: StudentListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.student_list_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(StudentListViewModel::class.java)
        // TODO: Use the ViewModel
    }

}