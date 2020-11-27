package com.example.studenthelper.VM.Factory

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.studenthelper.VM.TeacherViewModel
import com.example.studenthelper.model.Teacher

class TeacherViewModelFactory(private val application: Application, private val teacher: Teacher) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return TeacherViewModel(application, teacher) as T
    }
}