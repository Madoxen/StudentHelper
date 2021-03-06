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
import com.example.studenthelper.VM.StudentListViewModel
import com.example.studenthelper.model.Student

class AddStudentFragment : Fragment() {

    private val viewModel: StudentListViewModel by activityViewModels()
    private lateinit var studentFirstNameEditText: EditText
    private lateinit var studentLastNameEditText: EditText
    private lateinit var confirmButton: Button
    private lateinit var navController: NavController
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_add_student, container, false)
        studentFirstNameEditText = v.findViewById(R.id.studentFirstName_EditText)
        studentLastNameEditText = v.findViewById(R.id.studentLastName_EditText)
        confirmButton = v.findViewById(R.id.addStudentConfirm_button)
        return v
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = view.findNavController()
        confirmButton.setOnClickListener {
            viewModel.addNewStudent(
                Student(
                    0,
                    studentFirstNameEditText.text.toString(),
                    studentLastNameEditText.text.toString()
                )
            )
            //return to previous fragment
            view.clearFocus()
            navController.navigate(R.id.action_addStudentFragment_pop)
        }
    }


    companion object {
        @JvmStatic
        fun newInstance() =
            AddStudentFragment()
    }
}