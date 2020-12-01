package com.example.studenthelper.model.repos

import androidx.lifecycle.LiveData
import com.example.studenthelper.model.Course
import com.example.studenthelper.model.CourseStudentCrossRef
import com.example.studenthelper.model.CourseWithStudents
import com.example.studenthelper.model.CourseWithStudentsDAO

class CourseStudentRepo(private val courseStudentDao: CourseWithStudentsDAO) {

    fun getStudentsForCourse(course: Course): LiveData<CourseWithStudents> {
        return courseStudentDao.getCourseWithStudents(course.courseID)
    }

    fun getStudentsForCourse(courseID: Long): LiveData<CourseWithStudents> {
        return courseStudentDao.getCourseWithStudents(courseID)
    }

    suspend fun add(relation: CourseStudentCrossRef) {
        courseStudentDao.insert(relation)
    }

    suspend fun delete(relation: CourseStudentCrossRef) {
        courseStudentDao.delete(relation)
    }
}