package com.example.studenthelper.model.repos

import androidx.lifecycle.LiveData
import com.example.studenthelper.model.Student
import com.example.studenthelper.model.StudentDAO


class StudentRepo(private val studentDao: StudentDAO) {
    val readAll: LiveData<List<Student>> = studentDao.all()


    suspend fun add(student:Student) {
        studentDao.insert(student)
    }

    suspend fun delete(student:Student)=studentDao.delete(student)

}