package com.example.studenthelper.model

import androidx.lifecycle.LiveData
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

interface MarkDAO {

    @Insert
    suspend fun insert(mark: Mark)

    @Delete
    suspend fun delete(mark: Mark)

    @Query("select * from course_table")
    fun all(): LiveData<List<Mark>> //use async requests

}