package com.example.studenthelper.model

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query


@Dao
interface StudentDAO {

    @Insert
    suspend fun insert(student: Student)

    @Delete
    suspend fun delete(student: Student)

    @Query("select * from student_table")
    fun all(): LiveData<List<Student>>


    @Query("select * from student_table where ID in (select studentID from student_course_cross where courseID = :courseID)")
    fun getStudentsByCourse(courseID: Long) : LiveData<List<Student>>


    @Query("select * from student_table where ID not in (select studentID from student_course_cross where courseID = :courseID)")
    fun getStudentsNotInCourse(courseID: Long) : LiveData<List<Student>>


}