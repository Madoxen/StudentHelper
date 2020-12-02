package com.example.studenthelper.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.example.studenthelper.R
import com.example.studenthelper.VM.Factory.StudentViewModelFactory
import com.example.studenthelper.VM.StudentViewModel
import com.example.studenthelper.model.Mark


/**
 * A simple [Fragment] subclass.
 * Use the [AddNewMarkFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AddNewMarkFragment : Fragment() {
    private val viewModel: StudentViewModel by viewModels {
        StudentViewModelFactory(requireActivity().application, arguments?.get("relationID") as Long)
    }

    private lateinit var markEditTextView: EditText
    private lateinit var markNoteEditTextView: EditText
    private lateinit var confirmButton: Button
    private lateinit var navController: NavController
    private val calendar = java.util.Calendar.getInstance();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_add_new_mark, container, false)
        markEditTextView = v.findViewById(R.id.mark_EditView)
        markNoteEditTextView = v.findViewById(R.id.markNote_EditView)
        confirmButton = v.findViewById(R.id.confirm_button)
        return v
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = view.findNavController()
        confirmButton.setOnClickListener() {
            viewModel.addNewMark(
                Mark(
                    0,
                    viewModel.studentCourseRelationID,
                    markEditTextView.text.toString().toInt(),
                    markNoteEditTextView.text.toString(),
                    calendar.time
                )
            )
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = AddNewMarkFragment()
    }
}