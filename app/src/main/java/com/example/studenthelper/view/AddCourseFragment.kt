package com.example.studenthelper.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.example.studenthelper.R
import com.example.studenthelper.VM.CourseListViewModel
import com.example.studenthelper.model.Course

class AddCourseFragment : Fragment() {

    private val viewModel: CourseListViewModel by activityViewModels()

    private lateinit var confirmButton: Button
    private lateinit var courseEditText: EditText
    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.fragment_add_course, container, false)
        confirmButton = v.findViewById(R.id.addCourseConfirm_button)
        courseEditText = v.findViewById(R.id.courseName_editText)
        return v
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = view.findNavController()
        confirmButton.setOnClickListener {
            viewModel.addNewCourse(
                Course(0, courseEditText.text.toString())
            )
            view.clearFocus()
            navController.navigate(R.id.action_addCourseFragment_pop)
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = AddCourseFragment()
    }
}