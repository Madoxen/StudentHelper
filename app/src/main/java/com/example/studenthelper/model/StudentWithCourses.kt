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
        associateBy = Junction(StudentCourseCrossRef::class)
    )
    val courses: List<Course>
)


data class CourseWithStudents(
    @Embedded
    val course: Course,
    @Relation(
        parentColumn = "courseID",
        entityColumn = "teacherID",
        associateBy = Junction(StudentCourseCrossRef::class)
    )
    val students: List<Student>)

