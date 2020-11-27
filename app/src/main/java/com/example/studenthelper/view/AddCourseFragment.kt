package com.example.studenthelper.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.studenthelper.R
import com.example.studenthelper.VM.CourseViewModel
import com.example.studenthelper.VM.TeacherListViewModel
import com.example.studenthelper.VM.TeacherViewModel
import com.example.studenthelper.model.Course
import com.example.studenthelper.model.Teacher

class AddCourseFragment : Fragment() {


    lateinit var viewModel: TeacherViewModel;

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
        // Inflate the layout for this fragment
        viewModel =
            ViewModelProvider(requireActivity()).get(TeacherViewModel::class.java) //This view model is bound to activity
        return inflater.inflate(R.layout.fragment_add_teacher, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val b: Button = view.findViewById<Button>(R.id.confirm_button)
        val firstNameEditText = view.findViewById<EditText>(R.id.teacherFirstName_editText)
        val lastNameEditText = view.findViewById<EditText>(R.id.teacherLastName_editText)


        b.setOnClickListener {
            viewModel.addNewCourseToTeacher(
                Course(0,"") //TODO: change this to add existing courses
            )
            view.clearFocus();
            view.findNavController().navigate(R.id.action_addTeacherFragment_pop)
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = AddTeacherFragment();
    }
}