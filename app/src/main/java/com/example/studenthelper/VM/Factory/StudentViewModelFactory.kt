package com.example.studenthelper.VM.Factory

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.studenthelper.VM.StudentViewModel

class StudentViewModelFactory(val application: Application, private val studentCourseID: Long) :
    ViewModelProvider.AndroidViewModelFactory(
        application
    ) {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return StudentViewModel(application, studentCourseID) as T
    }
}