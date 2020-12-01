package com.example.studenthelper.view.Adapter

import android.app.Activity
import android.view.*
import android.widget.CheckBox
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.studenthelper.R
import com.example.studenthelper.model.Student

class StudentListAdapter(
    val students: LiveData<List<Student>>,
    val activity: Activity,
    val deleteStudentCallback: (List<Student>) -> Unit
) : RecyclerView.Adapter<StudentListAdapter.StudentViewHolder>() {

    private var actionMode: ActionMode? = null;
    private val selectedStudents: MutableList<Student> = ArrayList<Student>();


    private val actionModeCallback = object : ActionMode.Callback {
        // Called when the action mode is created; startActionMode() was called
        override fun onCreateActionMode(mode: ActionMode, menu: Menu): Boolean {
            // Inflate a menu resource providing context menu items
            val inflater: MenuInflater = mode.menuInflater
            inflater.inflate(R.menu.list_context_action_menu, menu)
            return true
        }

        // Called each time the action mode is shown. Always called after onCreateActionMode, but
        // may be called multiple times if the mode is invalidated.
        override fun onPrepareActionMode(mode: ActionMode, menu: Menu): Boolean {
            return false // Return false if nothing is done
        }

        // Called when the user selects a contextual menu item
        override fun onActionItemClicked(mode: ActionMode, item: MenuItem): Boolean {
            return when (item.itemId) {
                R.id.menu_deleteItems -> {
                    deleteStudentCallback(selectedStudents)
                    mode.finish() // Action picked, so close the CAB
                    true
                }
                else -> false
            }
        }

        // Called when the user exits the action mode
        override fun onDestroyActionMode(mode: ActionMode) {
            actionMode = null
        }

    }


    class StudentViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textViewFirstName = view.findViewById<TextView>(R.id.firstNameTextView)
        val textViewLastName = view.findViewById<TextView>(R.id.lastNameTextView)
        val selectionToggle = view.findViewById<CheckBox>(R.id.studentSelect_checkBox)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.student_entry, parent, false)
        return StudentViewHolder(
            view
        )
    }

    override fun getItemCount(): Int {
        return students.value?.size ?: 0
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        holder.textViewFirstName.text = students.value?.get(position)?.firstName
        holder.textViewLastName.text = students.value?.get(position)?.lastName
        holder.itemView.setOnLongClickListener() {
            when (actionMode) {
                null -> {

                    // Start the CAB using the ActionMode.Callback defined above
                    actionMode = activity.startActionMode(actionModeCallback)
                    holder.itemView.isSelected = true;
                    holder.selectionToggle.toggle();
                    true
                }
                else -> false
            }
        }

        holder.itemView.setOnClickListener {
            if(actionMode != null)
            {
                    holder.itemView.isSelected = !holder.itemView.isSelected;
                    holder.selectionToggle.toggle()
            }
        }

    }
}