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
import com.example.studenthelper.model.Mark
import com.example.studenthelper.view.Base.IHasItemDetails

class MarkListAdapter(
    val marks: LiveData<List<Mark>>?
) : RecyclerView.Adapter<MarkListAdapter.MarkViewHolder>() {

    init {
        setHasStableIds(true)
    }

    var tracker: SelectionTracker<Long>? = null

    class MarkViewHolder(view: View) : RecyclerView.ViewHolder(view), IHasItemDetails<Long> {
        val markTextView = view.findViewById<TextView>(R.id.mark_textView)
        val noteTextView = view.findViewById<TextView>(R.id.markNote_textView)
        val dateTextView = view.findViewById<TextView>(R.id.markDate_textView)
        val selectionToggle = view.findViewById<CheckBox>(R.id.markEntry_selectionCheckBox)

        override fun getItemDetails(): ItemDetailsLookup.ItemDetails<Long> =
            object : ItemDetailsLookup.ItemDetails<Long>() {
                override fun getSelectionKey(): Long? = itemId
                override fun getPosition(): Int = adapterPosition
            }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MarkViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.mark_entry, parent, false)
        return MarkViewHolder(
            view
        )
    }

    override fun getItemCount(): Int {
        return marks?.value?.size ?: 0
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun onBindViewHolder(holder: MarkViewHolder, position: Int) {
        holder.markTextView.text = marks?.value?.get(position)?.mark.toString()
        holder.noteTextView.text = marks?.value?.get(position)?.note
        holder.dateTextView.text = marks?.value?.get(position)?.date.toString()


        if (tracker != null) { //bad practice, tracker could have changed in the different thread
            //buuut i know it wont because nothing really changes it
            if (tracker!!.isSelected(position.toLong()))
                holder.selectionToggle.visibility = View.VISIBLE
            else
                holder.selectionToggle.visibility = View.GONE

            holder.selectionToggle.isChecked = tracker!!.isSelected(position.toLong())
        } else {
            holder.selectionToggle.visibility = View.GONE
        }


    }
}
