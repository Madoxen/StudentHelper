package com.example.studenthelper.VM

import android.app.Application
import androidx.lifecycle.*
import com.example.sqlite_example.model.StudentHelperDatabase
import com.example.studenthelper.model.Course
import com.example.studenthelper.model.Student
import com.example.studenthelper.model.Teacher
import com.example.studenthelper.model.repos.StudentRepo
import com.example.studenthelper.model.repos.TeacherRepo
import kotlinx.coroutines.launch

class TeacherListViewModel(application: Application) : AndroidViewModel(application) {

    private val repo : TeacherRepo ;
    val teachers: LiveData<List<Teacher>>;

    init
    {
         repo = TeacherRepo(StudentHelperDatabase.getDatabase(application).teacherDao());
         teachers = repo.readAll;
    }


    fun addNewTeacher(teacher: Teacher) {
        viewModelScope.launch { //launch new coroutine to avoid blocking main thread
            repo.add(teacher)
        }
    }

    fun removeTeacher(teacher: Teacher) {
        viewModelScope.launch { //launch new coroutine to avoid blocking main thread
            repo.delete(teacher)
        }
    }
}