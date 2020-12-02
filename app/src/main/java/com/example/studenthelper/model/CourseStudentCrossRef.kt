package com.example.studenthelper.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey


@Entity(
    tableName = "student_course_cross",
    foreignKeys = [ForeignKey(
        entity = Student::class,
        parentColumns = ["ID"],
        childColumns = ["studentID"],
        onDelete = CASCADE
    ),
        ForeignKey(
            entity = Course::class,
            parentColumns = ["ID"],
            childColumns = ["courseID"],
            onDelete = CASCADE
        )]
)
data class CourseStudentCrossRef(
    @PrimaryKey(autoGenerate = true) val ID: Long,
    val courseID: Long,
    val studentID: Long
)

