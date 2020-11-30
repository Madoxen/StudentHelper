package com.example.studenthelper.model

import androidx.lifecycle.LiveData
import androidx.room.Query
import androidx.room.Transaction

interface CourseWithStudentsDAO {

    @Transaction
    @Query("select * from student_table")
    fun getStudentWithCourses(): LiveData<List<StudentWithCourses>> //use async requests

    @Transaction
    @Query("select * from course_table where :cid = courseID")
    fun getCourseWithStudents(cid : Long): LiveData<List<CourseWithStudents>> //use async requests

}