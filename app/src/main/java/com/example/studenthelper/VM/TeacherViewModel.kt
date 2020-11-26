package com.example.studenthelper.VM

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.studenthelper.model.Teacher

class TeacherViewModel : ViewModel() {
    val teachers: LiveData<List<Teacher>> = MutableLiveData<List<Teacher>>();
}