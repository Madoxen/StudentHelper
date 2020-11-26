package com.example.studenthelper.model

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface CourseDAO {


    @Insert
    fun insert(course: Course)

    @Delete
    fun delete(course: Course)

    @Query("select * from course_table")
    fun all(): LiveData<List<Student>> //use async requests


}