package com.example.studenthelper.VM

import android.app.Application
import androidx.lifecycle.*
import com.example.sqlite_example.model.StudentHelperDatabase
import com.example.studenthelper.model.Course
import com.example.studenthelper.model.CourseWithStudents
import com.example.studenthelper.model.repos.CourseRepo
import com.example.studenthelper.model.repos.CourseStudentRepo

class CourseViewModel(application: Application, representedCourseID: Long) :
    AndroidViewModel(application) {

    private val repo: CourseStudentRepo =
        CourseStudentRepo(StudentHelperDatabase.getDatabase(application).courseStudentDao());
    val students: LiveData<CourseWithStudents> = repo.getStudentsForCourse(representedCourseID);
    val representedCourse: LiveData<Course> =
        CourseRepo(StudentHelperDatabase.getDatabase(application).courseDao()).read(representedCourseID);
}