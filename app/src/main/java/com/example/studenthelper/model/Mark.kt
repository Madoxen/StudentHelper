package com.example.studenthelper.model
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "mark_table")
data class Mark(@PrimaryKey(autoGenerate = true)val markID: Long, val courseStudentID : Long, val mark: Int, val note: String)


