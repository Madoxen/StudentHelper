package com.example.studenthelper.VM

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.studenthelper.model.Student

class CourseViewModel : ViewModel() {
    val students : LiveData<List<Student>> = MutableLiveData<List<Student>>();


}