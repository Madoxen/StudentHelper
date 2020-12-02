package com.example.studenthelper.view.Base

import androidx.recyclerview.selection.ItemDetailsLookup


//Interface used in conjunction with RVLookup
//For now used only with RecyclerView.ViewHolder types to signify that those types have ItemDetails
//Associated with them
//K - type of key - Supported types for selection-addon are: String, Long, Parcelable (from docs)
interface IHasItemDetails<T> {
    fun getItemDetails() : ItemDetailsLookup.ItemDetails<T>
}