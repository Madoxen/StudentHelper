package com.example.studenthelper.model

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation

data class TeacherWithCourses(
    @Embedded
    val teacher: Teacher,
    @Relation(
        parentColumn = "teacherID",
        entityColumn = "courseID",
        associateBy = Junction(TeacherCourseCrossRef::class)
    )
    val courses: List<Course>
)


data class CourseWithTeachers(
    @Embedded
    val course: Course,
    @Relation(
        parentColumn = "courseID",
        entityColumn = "teacherID",
        associateBy = Junction(TeacherCourseCrossRef::class)
    )
    val teachers: List<Teacher>
)

