package com.example.studenthelper.model.repos

import androidx.lifecycle.LiveData
import com.example.studenthelper.model.Course
import com.example.studenthelper.model.CourseStudentCrossRef
import com.example.studenthelper.model.CourseWithStudentsDAO

class CourseStudentRepo(private val courseStudentDao: CourseWithStudentsDAO) {

    suspend fun add(relation: CourseStudentCrossRef) {
        courseStudentDao.insert(relation)
    }

    suspend fun delete(relation: CourseStudentCrossRef) {
        courseStudentDao.delete(relation)
    }

    fun readForCourse(courseID : Long): LiveData<List<CourseStudentCrossRef>> {
        return courseStudentDao.readForCourse(courseID);
    }
}