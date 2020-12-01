package com.example.studenthelper.VM.Factory

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.studenthelper.VM.CourseViewModel

class CourseViewModelFactory(val application: Application, val representedCourseID: Long) :
    ViewModelProvider.AndroidViewModelFactory(
        application
    ) {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return CourseViewModel(application, representedCourseID) as T
    }
}