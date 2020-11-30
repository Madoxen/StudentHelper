package com.example.studenthelper.model.repos

import androidx.lifecycle.LiveData
import com.example.studenthelper.model.Course
import com.example.studenthelper.model.CourseDAO
import com.example.studenthelper.model.Student
import com.example.studenthelper.model.StudentDAO

class CourseRepo(private val courseDao: CourseDAO) {
    val readAll: LiveData<List<Course>> = courseDao.all()


    suspend fun add(course: Course) {
        courseDao.insert(course)
    }

    suspend fun delete(course: Course)=courseDao.delete(course)




}