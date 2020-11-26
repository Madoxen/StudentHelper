package com.example.studenthelper.VM

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.studenthelper.model.Course
import com.example.studenthelper.model.Student
import com.example.studenthelper.model.Teacher

class TeacherListViewModel : ViewModel() {
    val teachers: LiveData<List<Course>> = MutableLiveData<List<Course>>();
}