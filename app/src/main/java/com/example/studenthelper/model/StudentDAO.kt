package com.example.studenthelper.model

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query


@Dao
interface StudentDAO {

    @Insert
    fun insert(student: Student)

    @Delete
    fun delete(student: Student)

    @Query("select * from student_table")
    fun all(): List<Student>;


}