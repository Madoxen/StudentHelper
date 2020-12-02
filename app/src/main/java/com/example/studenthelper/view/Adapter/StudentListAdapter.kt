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
import com.example.studenthelper.model.Student
import com.example.studenthelper.view.Base.IHasItemDetails


class StudentListAdapter(
    val students: LiveData<List<Student>>?,
    private val chooseCallback: (Student) -> Unit = {}
) : RecyclerView.Adapter<StudentListAdapter.StudentViewHolder>() {

    init {
        setHasStableIds(true)
    }

    var tracker: SelectionTracker<Long>? = null

    class StudentViewHolder(view: View) : RecyclerView.ViewHolder(view), IHasItemDetails<Long> {
        val textViewFirstName = view.findViewById<TextView>(R.id.firstNameTextView)
        val textViewLastName = view.findViewById<TextView>(R.id.lastNameTextView)
        val selectionToggle = view.findViewById<CheckBox>(R.id.studentSelect_checkBox)

        override fun getItemDetails(): ItemDetailsLookup.ItemDetails<Long> =
            object : ItemDetailsLookup.ItemDetails<Long>() {
                override fun getSelectionKey(): Long? = itemId
                override fun getPosition(): Int = adapterPosition
            }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.student_entry, parent, false)
        return StudentViewHolder(
            view
        )
    }

    override fun getItemCount(): Int {
        return students?.value?.size ?: 0
    }


    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        holder.textViewFirstName.text = students?.value?.get(position)?.firstName
        holder.textViewLastName.text = students?.value?.get(position)?.lastName

        if (tracker!!.isSelected(position.toLong()))
            holder.selectionToggle.visibility = View.VISIBLE
        else
            holder.selectionToggle.visibility = View.GONE

        holder.selectionToggle.isChecked = tracker!!.isSelected(position.toLong())


        holder.itemView.setOnClickListener {
            students?.value?.get(holder.adapterPosition)?.let { student ->
                chooseCallback(
                    student
                )
            }
        }
    }
}


