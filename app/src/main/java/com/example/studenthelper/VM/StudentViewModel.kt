package com.example.studenthelper.VM

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.sqlite_example.model.StudentHelperDatabase
import com.example.studenthelper.model.Mark
import com.example.studenthelper.model.repos.MarkRepo
import kotlinx.coroutines.launch

class StudentViewModel(application: Application, val studentCourseRelationID: Long) : AndroidViewModel(application) {

    private val markRepo = MarkRepo(StudentHelperDatabase.getDatabase(application).markDao())
    val marks = markRepo.readForStudentCourse(studentCourseRelationID)

    fun addNewMark(m: Mark)
    {
        viewModelScope.launch {
            markRepo.add(m)
        }
    }

    fun removeMark(m: Mark)
    {
        viewModelScope.launch {
            markRepo.delete(m)
        }
    }

}