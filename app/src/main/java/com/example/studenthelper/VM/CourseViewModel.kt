package com.example.studenthelper.VM

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.sqlite_example.model.StudentHelperDatabase
import com.example.studenthelper.model.Course
import com.example.studenthelper.model.CourseStudentCrossRef
import com.example.studenthelper.model.CourseWithStudents
import com.example.studenthelper.model.Student
import com.example.studenthelper.model.repos.CourseRepo
import com.example.studenthelper.model.repos.CourseStudentRepo
import kotlinx.coroutines.launch

class CourseViewModel(application: Application, val representedCourseID: Long) :
    AndroidViewModel(application) {

    private val repo: CourseStudentRepo =
        CourseStudentRepo(StudentHelperDatabase.getDatabase(application).courseStudentDao())
    val courseWithStudents: LiveData<CourseWithStudents> =
        repo.getStudentsForCourse(representedCourseID)
    val students: LiveData<List<Student>> =
        MutableLiveData(courseWithStudents.value?.students ?: ArrayList<Student>())
    val representedCourse: LiveData<Course> =
        CourseRepo(StudentHelperDatabase.getDatabase(application).courseDao()).read(
            representedCourseID
        )

    fun addStudentToCourse(student: Student) {
        viewModelScope.launch { //launch new coroutine to avoid blocking main thread
            repo.add(CourseStudentCrossRef(0, representedCourseID, student.studentID))
        }
    }

    fun removeStudentFromCourse(student: Student) {
        viewModelScope.launch { //launch new coroutine to avoid blocking main thread
            repo.delete(CourseStudentCrossRef(0, representedCourseID, student.studentID))
        }
    }
}