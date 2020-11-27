package com.example.studenthelper.VM

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.sqlite_example.model.StudentHelperDatabase
import com.example.studenthelper.model.Course
import com.example.studenthelper.model.Student
import com.example.studenthelper.model.repos.StudentRepo
import kotlinx.coroutines.launch

class StudentListViewModel(application: Application) : AndroidViewModel(application) {
    private val repo: StudentRepo;
    val students: LiveData<List<Student>>;

    init {
        repo = StudentRepo(StudentHelperDatabase.getDatabase(application).studentDao());
        students = repo.readAll;
    }


    fun addNewTeacher(student: Student) {
        viewModelScope.launch { //launch new coroutine to avoid blocking main thread
            repo.add(student)
        }
    }

    fun removeTeacher(student: Student) {
        viewModelScope.launch { //launch new coroutine to avoid blocking main thread
            repo.delete(student)
        }
    }
}