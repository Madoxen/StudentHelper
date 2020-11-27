package com.example.studenthelper.view.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.studenthelper.R
import com.example.studenthelper.model.Student

class StudentListAdapter(
    val students: LiveData<List<Student>>,
    val deleteStudentCallback: (Student) -> Unit
) : RecyclerView.Adapter<StudentListAdapter.StudentViewHolder>() {


    class StudentViewHolder(view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.student_entry, parent, false)
        return StudentViewHolder(
            view
        )
    }

    override fun getItemCount(): Int {
        return students.value?.size ?: 0;
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val textViewFirstName = holder.itemView.findViewById<TextView>(R.id.firstNameTextView)
        val textViewLastName = holder.itemView.findViewById<TextView>(R.id.lastNameTextView)
        val deleteStudentButton = holder.itemView.findViewById<Button>(R.id.deleteStudentButton);



        textViewFirstName.text = students.value?.get(position)?.firstName
        textViewLastName.text = students.value?.get(position)?.lastName
        //assign callback
        deleteStudentButton.setOnClickListener() {
            students.value?.get(position)
                ?.let { chosenStudent -> deleteStudentCallback(chosenStudent) };
        }
    }

}