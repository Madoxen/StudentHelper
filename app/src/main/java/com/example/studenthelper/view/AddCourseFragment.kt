package com.example.studenthelper.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.studenthelper.R
import com.example.studenthelper.VM.CourseListViewModel
import com.example.studenthelper.model.Course

class AddCourseFragment : Fragment() {

    val viewModel: CourseListViewModel by activityViewModels();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_add_course, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val b: Button = view.findViewById<Button>(R.id.addCourseConfirm_button)
        val courseEditText = view.findViewById<EditText>(R.id.courseName_editText)


        b.setOnClickListener {
            viewModel.addNewCourse(
                Course(0,courseEditText.text.toString())
            )
            view.clearFocus();
            view.findNavController().navigate(R.id.action_addCourseFragment_pop)
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = AddCourseFragment();
    }
}