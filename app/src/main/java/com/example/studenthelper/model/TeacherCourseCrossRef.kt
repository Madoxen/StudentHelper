package com.example.studenthelper.model

import androidx.room.Entity


@Entity(primaryKeys = ["teacherID", "courseID"])
data class TeacherCourseCrossRef(val teacherID: Long, val courseID: Long )

