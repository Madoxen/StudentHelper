package com.example.studenthelper.model

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface TeacherCourseDao {
    @Transaction
    @Query("SELECT * FROM teacher_table")
    fun getTeachersWithCourses(): LiveData<List<TeacherWithCourses>>

    @Transaction
    @Query("SELECT * FROM course_table")
    fun getCoursesWithTeachers(): LiveData<List<CourseWithTeachers>>


    @Transaction
    @Query("SELECT * FROM teacher_table where teacherID = :teacherID")
    fun getTeachersCourses(teacherID: Long) : LiveData<List<TeacherWithCourses>>

    @Insert
    suspend fun insertTeacherCourse(relation: TeacherCourseCrossRef)

    @Delete
    suspend fun deleteTeacherCourse(relation: TeacherCourseCrossRef)

}