package com.example.studenthelper.model.repos

import androidx.lifecycle.LiveData
import com.example.studenthelper.model.Student
import com.example.studenthelper.model.StudentDAO


class StudentRepo(private val studentDao: StudentDAO) {
    val readAll: LiveData<List<Student>> = studentDao.all()


    fun getStudentsInCourse(courseID: Long): LiveData<List<Student>> {
        return studentDao.getStudentsByCourse(courseID)
    }

    suspend fun add(student: Student) {
        studentDao.insert(student)
    }

    suspend fun delete(student: Student) = studentDao.delete(student)

}