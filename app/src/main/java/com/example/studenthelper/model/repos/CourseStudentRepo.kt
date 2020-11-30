package com.example.studenthelper.model.repos

import androidx.lifecycle.LiveData
import com.example.studenthelper.model.*

public class CourseStudentRepo(private val courseStudentDao: CourseWithStudentsDAO) {

    fun getStudentsForCourse(course: Course): LiveData<CourseWithStudents> {
        return courseStudentDao.getCourseWithStudents(course.courseID);
    }

    suspend fun add(relation: CourseStudentCrossRef) {
        courseStudentDao.insert(relation)
    }

    suspend fun delete(relation: CourseStudentCrossRef) {
        courseStudentDao.delete(relation)
    }
}