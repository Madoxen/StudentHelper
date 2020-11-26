package com.example.studenthelper.model

import androidx.room.Entity


@Entity(primaryKeys = ["studentID", "courseID"])
data class StudentCourseCrossRef(val studentID: Long, val courseID: Long);

