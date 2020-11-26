package com.example.studenthelper.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "course_table")
class Course(@PrimaryKey(autoGenerate = true) val id: Int, var name: String) {

}