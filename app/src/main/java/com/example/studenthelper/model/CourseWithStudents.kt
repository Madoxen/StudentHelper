package com.example.studenthelper.model

import androidx.lifecycle.LiveData
import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation


data class CourseWithStudents(
    @Embedded
    val course: Course,

    @Relation(
        parentColumn = "playlistId",
        entityColumn = "songId",
        associateBy = Junction(CourseWithStudents::class)
    )
    val students: LiveData<List<Student>>
)
