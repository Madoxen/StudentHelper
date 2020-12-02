package com.example.studenthelper.VM

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.observe
import androidx.lifecycle.viewModelScope
import com.example.sqlite_example.model.StudentHelperDatabase
import com.example.studenthelper.model.CourseStudentCrossRef
import com.example.studenthelper.model.Student
import com.example.studenthelper.model.repos.CourseStudentRepo
import com.example.studenthelper.model.repos.StudentRepo
import kotlinx.coroutines.launch

class CourseViewModel(application: Application, representedCourseID: Long) :
    AndroidViewModel(application) {

    private val relationRepo: CourseStudentRepo =
        CourseStudentRepo(StudentHelperDatabase.getDatabase(application).courseStudentDao())

    private val studentRepo: StudentRepo =
        StudentRepo(StudentHelperDatabase.getDatabase(application).studentDao())


    var representedCourseID = representedCourseID
        get() = field
        set(value) {
            field = value
            students = studentRepo.getStudentsInCourse(representedCourseID) //refresh
            relations = relationRepo.readForCourse(representedCourseID)
        }
    var students: LiveData<List<Student>> =
        studentRepo.getStudentsInCourse(representedCourseID)


     var relations: LiveData<List<CourseStudentCrossRef>> =
        relationRepo.readForCourse(representedCourseID)


    fun addStudentToCourse(student: Student) {
        viewModelScope.launch { //launch new coroutine to avoid blocking main thread
            relationRepo.add(CourseStudentCrossRef(0, representedCourseID, student.ID))
        }
    }

    fun removeStudentFromCourse(student: Student) {
        viewModelScope.launch { //launch new coroutine to avoid blocking main thread
            val relationToDelete = relations.value?.find { x -> x.studentID == student.ID }
            if (relationToDelete != null) {
                relationRepo.delete(relationToDelete)
            }
        }
    }
}