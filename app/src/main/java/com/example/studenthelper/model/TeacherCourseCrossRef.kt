package com.example.studenthelper.model

import androidx.room.Entity


@Entity(primaryKeys = ["teacherID", "courseID"])
class TeacherCourseCrossRef(val teacherID: Long, val courseID: Long )

