package com.example.studenthelper.view

import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.studenthelper.model.Course

class CourseListAdapter(data : LiveData<List<Course>>) :
    RecyclerView.Adapter<CourseListAdapter.CourseViewHolder>() {
    class CourseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseViewHolder {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: CourseViewHolder, position: Int) {
        TODO("Not yet implemented")
    }
}