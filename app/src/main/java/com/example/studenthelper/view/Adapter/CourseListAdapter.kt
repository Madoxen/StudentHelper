package com.example.studenthelper.view.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.studenthelper.R
import com.example.studenthelper.model.Course

class CourseListAdapter(
    private val data: LiveData<List<Course>>,
    private val chooseCallback: (Course) -> Unit,
    private val deleteCallback: (Course) -> Unit
) :
    RecyclerView.Adapter<CourseListAdapter.CourseViewHolder>() {

    class CourseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.courseEntryName_textView)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(
                R.layout.course_entry,
                parent,
                false
            )

        return CourseViewHolder(
            view
        )
    }

    override fun getItemCount(): Int {
        return data.value?.size ?: 0;
    }

    override fun onBindViewHolder(holder: CourseViewHolder, position: Int) {
        holder.name.text = data.value?.get(position)?.name ?: "Error fetching data";
        holder.itemView.setOnClickListener {
            data.value?.get(position)?.let { course -> chooseCallback(course) };
        }
    }
}