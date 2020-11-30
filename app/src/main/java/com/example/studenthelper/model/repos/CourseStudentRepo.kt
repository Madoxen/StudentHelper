package com.example.studenthelper.model.repos

import androidx.lifecycle.LiveData
import com.example.studenthelper.model.CourseWithStudents
import com.example.studenthelper.model.CourseWithStudentsDAO
import com.example.studenthelper.model.Student

class CourseStudentRepo(courseStudentDao: CourseWithStudentsDAO) {

    fun getStudentsForCourse: LiveData<CourseWithStudents> = courseStudentDao.getCourseWithStudents()


    suspend fun add(student: Student) {
        studentDao.insert(student)
    }

    suspend fun delete(student: Student)=studentDao.delete(student)
}