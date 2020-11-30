package com.example.studenthelper.VM

import android.app.Application
import androidx.lifecycle.*
import com.example.sqlite_example.model.StudentHelperDatabase
import com.example.studenthelper.model.Course
import com.example.studenthelper.model.CourseWithStudents
import com.example.studenthelper.model.Student
import com.example.studenthelper.model.repos.StudentRepo

class CourseViewModel(application: Application, representedCourse : Course) : AndroidViewModel(application) {

    val repo : StudentRepo = StudentRepo(StudentHelperDatabase.getDatabase(application).studentDao());
    val students : LiveData<CourseWithStudents> = repo.;


}