package com.example.studenthelper.VM.Factory

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.studenthelper.VM.CourseViewModel
import com.example.studenthelper.model.Course

class CourseViewModelFactory(val application: Application, val representedCourse: Course) :
    ViewModelProvider.AndroidViewModelFactory(
        application
    ) {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return CourseViewModel(application, representedCourse) as T;
    }
}