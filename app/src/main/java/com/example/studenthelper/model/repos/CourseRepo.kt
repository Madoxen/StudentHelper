package com.example.studenthelper.model.repos

import androidx.lifecycle.LiveData
import com.example.studenthelper.model.Course
import com.example.studenthelper.model.CourseDAO

class CourseRepo(private val courseDao: CourseDAO) {

    val readAll: LiveData<List<Course>> = courseDao.all()

    fun read(courseID: Long) : LiveData<Course> = courseDao.first(courseID);

    suspend fun add(course: Course) {
        courseDao.insert(course)
    }

    suspend fun delete(course: Course)=courseDao.delete(course)

}