package com.example.studenthelper.model

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation

data class StudentWithCourses(
    @Embedded
    val student: Student,
    @Relation(
        parentColumn = "studentID",
        entityColumn = "courseID",
        associateBy = Junction(CourseStudentCrossRef::class)
    )
    val courses: List<Course>
)


data class CourseWithStudents(
    @Embedded
    val course: Course,
    @Relation(
        parentColumn = "courseID",
        entityColumn = "studentID",
        associateBy = Junction(CourseStudentCrossRef::class)
    )
    val students: List<Student>
)

