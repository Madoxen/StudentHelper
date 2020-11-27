package com.example.studenthelper.model.repos

import androidx.lifecycle.LiveData
import com.example.studenthelper.model.*

class TeacherWithCourseRepo(private val teacherCourseDao: TeacherCourseDao) {

    val readAll: LiveData<List<TeacherWithCourses>> = teacherCourseDao.getTeachersWithCourses()

    fun getForTeacher(teacherID: Long): LiveData<List<TeacherWithCourses>> {
        return teacherCourseDao.getTeachersCourses(teacherID)
    }

    suspend fun add(teacherCourseCrossRef: TeacherCourseCrossRef) {
        teacherCourseDao.insertTeacherCourse(teacherCourseCrossRef)
    }

    suspend fun delete(teacherCourseCrossRef: TeacherCourseCrossRef) =
        teacherCourseDao.deleteTeacherCourse(teacherCourseCrossRef)

}