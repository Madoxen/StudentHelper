package com.example.studenthelper.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "teacher_table")
data class Teacher(
    @PrimaryKey(autoGenerate = true) val teacherID: Long,
    var firstName: String,
    var lastName: String
)

