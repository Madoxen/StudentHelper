package com.example.studenthelper.model.repos

import androidx.lifecycle.LiveData
import com.example.studenthelper.model.Mark
import com.example.studenthelper.model.MarkDAO

class MarkRepo(private val markDao: MarkDAO) {

    val readAll: LiveData<List<Mark>> = markDao.all()
    fun readForStudentCourse(studentCourseID: Long): LiveData<List<Mark>> =
        markDao.readForStudentCourse(studentCourseID)

    suspend fun add(mark: Mark) {
        markDao.insert(mark)
    }

    suspend fun delete(mark: Mark) = markDao.delete(mark)
}
