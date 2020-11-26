package com.example.studenthelper.model.repos

import androidx.lifecycle.LiveData
import com.example.studenthelper.model.Student
import com.example.studenthelper.model.StudentDAO
import com.example.studenthelper.model.Teacher
import com.example.studenthelper.model.TeacherDAO

class TeacherRepo(private val teacherDao: TeacherDAO) {
    val readAll: LiveData<List<Teacher>> = teacherDao.all()

    suspend fun add(teacher: Teacher) {
        teacherDao.insert(teacher)
    }

    suspend fun delete(teacher: Teacher)=teacherDao.delete(teacher)

}