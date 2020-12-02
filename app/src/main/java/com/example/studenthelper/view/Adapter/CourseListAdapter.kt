package com.example.studenthelper.view.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.recyclerview.selection.ItemDetailsLookup
import androidx.recyclerview.selection.SelectionTracker
import androidx.recyclerview.widget.RecyclerView
import com.example.studenthelper.R
import com.example.studenthelper.model.Course
import com.example.studenthelper.view.Base.IHasItemDetails


class CourseListAdapter(
    val courses: LiveData<List<Course>>,
    private val chooseCallback: (Course) -> Unit
) :
    RecyclerView.Adapter<CourseListAdapter.CourseViewHolder>() {
    var tracker: SelectionTracker<Long>? = null


    init {
        setHasStableIds(true)
    }

    class CourseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), IHasItemDetails<Long> {
        val name: TextView = itemView.findViewById(R.id.courseEntryName_textView)
        val selectionToggle: CheckBox = itemView.findViewById(R.id.courseSelect_checkBox)


        override fun getItemDetails(): ItemDetailsLookup.ItemDetails<Long> =
            object : ItemDetailsLookup.ItemDetails<Long>() {
                override fun getSelectionKey(): Long? = itemId
                override fun getPosition(): Int = adapterPosition
            }
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
        return courses.value?.size ?: 0
    }

    override fun onBindViewHolder(holder: CourseViewHolder, position: Int) {
        holder.name.text = courses.value?.get(position)?.name ?: "Error fetching data"
        holder.itemView.setOnClickListener {
            courses.value?.get(position)?.let { course -> chooseCallback(course) }
        }


        if (tracker!!.isSelected(position.toLong()))
            holder.selectionToggle.visibility = View.VISIBLE
        else
            holder.selectionToggle.visibility = View.GONE

        holder.selectionToggle.isChecked = tracker!!.isSelected(position.toLong())

    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }
}