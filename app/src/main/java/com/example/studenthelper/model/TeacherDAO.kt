package com.example.studenthelper.model

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query


@Dao
interface TeacherDAO {

    @Insert
    fun insert(teacher: Teacher)

    @Delete
    fun delete(teacher: Teacher)

    @Query("select * from teacher_table")
    fun all(): List<Teacher>;


}