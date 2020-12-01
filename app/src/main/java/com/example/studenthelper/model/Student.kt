package com.example.studenthelper.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "student_table")
data class Student(
    @PrimaryKey(autoGenerate = true) val studentID: Long,
    var firstName: String,
    var lastName: String
)