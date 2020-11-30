package com.example.studenthelper.model

import androidx.room.Entity


@Entity(primaryKeys = ["studentID", "courseID"], tableName = "student_course_cross")
data class StudentCourseCrossRef(val ID: Long, val studentID: Long, val courseID: Long);

