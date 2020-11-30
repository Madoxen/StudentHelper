package com.example.studenthelper.VM

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sqlite_example.model.StudentHelperDatabase
import com.example.studenthelper.model.Course
import com.example.studenthelper.model.repos.CourseRepo
import kotlinx.coroutines.launch

class CourseListViewModel(application: Application) : AndroidViewModel(application) {

    private val repo: CourseRepo;
    val courses: LiveData<List<Course>>;


    init {
        repo = CourseRepo(StudentHelperDatabase.getDatabase(application).courseDao());
        courses = repo.readAll;
    }


    fun addNewCourse(course: Course) {
        viewModelScope.launch { //launch new coroutine to avoid blocking main thread
            repo.add(course)
        }
    }

    fun removeCourse(course: Course) {
        viewModelScope.launch { //launch new coroutine to avoid blocking main thread
            repo.delete(course)
        }
    }
}