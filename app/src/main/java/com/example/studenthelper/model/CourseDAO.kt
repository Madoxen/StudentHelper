package com.example.studenthelper.model

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface CourseDAO {


    @Insert
    suspend fun insert(course: Course)

    @Delete
    suspend fun delete(course: Course)

    @Query("select * from course_table")
     fun all(): LiveData<List<Course>> //use async requests


    @Query("select * from course_table where courseID = :courseID ")
    fun first(courseID: Long): LiveData<Course> //use async requests

}