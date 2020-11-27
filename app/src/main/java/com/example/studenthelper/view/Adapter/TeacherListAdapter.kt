package com.example.studenthelper.view.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.studenthelper.R
import com.example.studenthelper.model.Teacher

class TeacherListAdapter(
    private val data: LiveData<List<Teacher>>,
    val deleteTeacherCallback: (Teacher) -> Unit,
    val teacherSelectedCallback: (Teacher) -> Unit
) :
    RecyclerView.Adapter<TeacherListAdapter.TeacherViewHolder>() {

    class TeacherViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeacherViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(
                R.layout.student_entry,
                parent,
                false
            ) //TODO: change student entry to new teacher entry for better control

        return TeacherViewHolder(
            view
        )
    }

    override fun getItemCount(): Int {
        return data.value?.size ?: 0;
    }

    override fun onBindViewHolder(holder: TeacherViewHolder, position: Int) {
        val textViewFirstName = holder.itemView.findViewById<TextView>(R.id.firstNameTextView)
        val textViewLastName = holder.itemView.findViewById<TextView>(R.id.lastNameTextView)
        val deleteStudentButton = holder.itemView.findViewById<Button>(R.id.deleteStudentButton);


        textViewFirstName.text = data.value?.get(position)?.firstName
        textViewLastName.text = data.value?.get(position)?.lastName
        //assign callback
        deleteStudentButton.setOnClickListener() {
            data.value?.get(position)
                ?.let { chosenTeacher -> deleteTeacherCallback(chosenTeacher) };
        }

        holder.itemView.setOnClickListener {
            data.value?.get(position)?.let { chosenTeacher ->
                teacherSelectedCallback(
                    chosenTeacher
                )
            };
            it.findNavController()
                .navigate(R.id.action_teacherListFragment_to_teacherViewFragment)
        }


    }
}