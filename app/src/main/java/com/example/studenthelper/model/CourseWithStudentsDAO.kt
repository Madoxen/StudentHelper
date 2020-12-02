package com.example.studenthelper.model

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface CourseWithStudentsDAO {

    @Query("select * from student_course_cross where courseID = :courseID")
    fun readForCourse(courseID: Long) : LiveData<List<CourseStudentCrossRef>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(relation: CourseStudentCrossRef)

    @Delete
    suspend fun delete(relation: CourseStudentCrossRef)


}