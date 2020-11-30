package com.example.studenthelper.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.studenthelper.R
import com.example.studenthelper.VM.CourseListViewModel
import com.example.studenthelper.VM.StudentListViewModel
import com.example.studenthelper.model.Course
import com.example.studenthelper.model.Student

class AddStudentFragment : Fragment() {

    lateinit var viewModel: StudentListViewModel;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        viewModel = ViewModelProvider(requireActivity()).get();
        return inflater.inflate(R.layout.fragment_add_student, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val studentFirstNameEditText = view.findViewById<EditText>(R.id.studentFirstName_EditText);
        val studentLastNameEditText = view.findViewById<EditText>(R.id.studentLastName_EditText);
        val confirmButton = view.findViewById<Button>(R.id.addStudentConfirm_button);

        confirmButton.setOnClickListener {
            viewModel.addNewStudent(
                Student(
                    0,
                    studentFirstNameEditText.text.toString(),
                    studentLastNameEditText.text.toString()
                )
            );

            //return to previous fragment
            view.clearFocus();
            view.findNavController().navigate(R.id.action_addCourseFragment_pop);
        }
    }


    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            AddStudentFragment()
    }
}