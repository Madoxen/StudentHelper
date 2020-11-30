package com.example.studenthelper.model

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface CourseWithStudentsDAO {

    @Transaction
    @Query("select * from student_table where :sid = studentID")
    fun getStudentWithCourses(sid: Long): LiveData<StudentWithCourses> //use async requests

    @Transaction
    @Query("select * from course_table where :cid = courseID")
    fun getCourseWithStudents(cid: Long): LiveData<CourseWithStudents> //use async requests

    @Insert
    suspend fun insert(relation: CourseStudentCrossRef)

    @Delete
    suspend fun delete(relation: CourseStudentCrossRef)
}