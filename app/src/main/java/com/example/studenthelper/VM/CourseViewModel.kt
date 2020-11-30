package com.example.studenthelper.VM

import android.app.Application
import androidx.lifecycle.*
import com.example.sqlite_example.model.StudentHelperDatabase
import com.example.studenthelper.model.Course
import com.example.studenthelper.model.CourseWithStudents
import com.example.studenthelper.model.Student
import com.example.studenthelper.model.repos.CourseStudentRepo
import com.example.studenthelper.model.repos.StudentRepo

class CourseViewModel(application: Application, representedCourse : Course) : AndroidViewModel(application) {

    private val repo : CourseStudentRepo = CourseStudentRepo(StudentHelperDatabase.getDatabase(application).courseStudentDao());
    val students : LiveData<CourseWithStudents> = repo.getStudentsForCourse(representedCourse);


}