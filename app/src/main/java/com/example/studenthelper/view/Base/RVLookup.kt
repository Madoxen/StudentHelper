package com.example.studenthelper.view.Base

import android.view.MotionEvent
import androidx.recyclerview.selection.ItemDetailsLookup
import androidx.recyclerview.widget.RecyclerView
import com.example.studenthelper.view.Adapter.StudentListAdapter

//RecyclerView lookup class
//Used for RV-selection addon, that needs this class for fast-lookup to check if something is selected
//K - type of key - Supported types for selection-addon are: String, Long, Parcelable (from docs)
//T - type of viewHolder that will be associated to the K key
class RVLookup<T : IHasItemDetails<K>, K>(private val rv: RecyclerView) : ItemDetailsLookup<K>() {
    override fun getItemDetails(event: MotionEvent)
            : ItemDetails<K>? {

        // More code here
        val view = rv.findChildViewUnder(event.x, event.y)
        if (view != null) {
            return (rv.getChildViewHolder(view) as T)
                .getItemDetails()
        }
        return null
    }
}