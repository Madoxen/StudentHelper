package com.example.studenthelper

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.studenthelper.VM.TeacherListViewModel
import com.example.studenthelper.model.Teacher
import com.google.android.material.floatingactionbutton.FloatingActionButton


/**
 * A simple [Fragment] subclass.
 * Use the [AddTeacherFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AddTeacherFragment : Fragment() {
    lateinit var viewModel: TeacherListViewModel;


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
            ViewModelProvider(requireActivity()).get(TeacherListViewModel::class.java) //This view model is bound to activity
        return inflater.inflate(R.layout.fragment_add_teacher, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val b: Button = view.findViewById<Button>(R.id.confirm_button)
        val firstNameEditText = view.findViewById<EditText>(R.id.teacherFirstName_editText)
        val lastNameEditText = view.findViewById<EditText>(R.id.teacherLastName_editText)


        b.setOnClickListener {
            viewModel.addNewTeacher(
                Teacher(
                    0,
                    firstNameEditText.text.toString(),
                    lastNameEditText.text.toString()
                )
            )
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = AddTeacherFragment();
    }
}