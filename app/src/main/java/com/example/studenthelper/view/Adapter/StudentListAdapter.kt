package com.example.studenthelper.view.Adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import android.widget.ToggleButton
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.studenthelper.R
import com.example.studenthelper.model.Student

class StudentListAdapter(
    val students: LiveData<List<Student>>,
    val deleteStudentCallback: (Student) -> Unit
) : RecyclerView.Adapter<StudentListAdapter.StudentViewHolder>() {


    class StudentViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textViewFirstName = view.findViewById<TextView>(R.id.firstNameTextView);
        val textViewLastName = view.findViewById<TextView>(R.id.lastNameTextView);
        val selectionToggle = view.findViewById<CheckBox>(R.id.studentSelect_checkBox)
            .also { it.visibility = toggleVis }

        companion object {
            @JvmStatic
            var toggleVis: Int = View.GONE
                get() = field;
                set(value) {
                    field = value
                    onToggleVisibilityChanged();
                }

            @JvmStatic
            fun onToggleVisibilityChanged() {
                //trigger change in all registered holders
                for (t in toggles) {
                    t.second();
                }
            }


            @JvmStatic
            var toggles: MutableList<Pair<View, () -> Unit>> = ArrayList<Pair<View, () -> Unit>>();


            @JvmStatic
            fun registerHolder(view: View, onVisibilityChangedHandler: () -> Unit) {
                toggles.add(Pair(view, onVisibilityChangedHandler));
            }
        }

        init {
            registerHolder(view) {
                selectionToggle.visibility = toggleVis;
            };
            toggleVis = View.GONE;
            view.setOnLongClickListener() {
                if (toggleVis != View.VISIBLE) {
                    toggleVis = View.VISIBLE;
                } else {
                    toggleVis = View.GONE;
                }
                false;
            }
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
        return students.value?.size ?: 0;
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        holder.textViewFirstName.text = students.value?.get(position)?.firstName
        holder.textViewLastName.text = students.value?.get(position)?.lastName
    }

}