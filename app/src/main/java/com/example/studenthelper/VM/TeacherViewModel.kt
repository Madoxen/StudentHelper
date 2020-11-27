package com.example.studenthelper.VM

import android.app.Application
import androidx.lifecycle.*
import com.example.sqlite_example.model.StudentHelperDatabase
import com.example.studenthelper.model.Course
import com.example.studenthelper.model.Teacher
import com.example.studenthelper.model.TeacherCourseCrossRef
import com.example.studenthelper.model.TeacherWithCourses
import com.example.studenthelper.model.repos.TeacherWithCourseRepo
import kotlinx.coroutines.launch

class TeacherViewModel(application: Application, teacher: Teacher) : AndroidViewModel(application) {

    private val repo : TeacherWithCourseRepo =
        TeacherWithCourseRepo(StudentHelperDatabase.getDatabase(application).teacherCourseDao());

    var teacherCourses: LiveData<List<TeacherWithCourses>> = MutableLiveData<List<TeacherWithCourses>>();

    var representedTeacher : Teacher = teacher
    get() { return representedTeacher; }
    set(value) {
        field = value;
        teacherCourses = repo.getForTeacher(field.teacherID)}


    fun addNewCourseToTeacher(course: Course) {
        viewModelScope.launch { //launch new coroutine to avoid blocking main thread
            repo.add(TeacherCourseCrossRef(representedTeacher.teacherID,course.courseID))
        }
    }

    fun removeCourseFromTeacher(course: Course) {
        viewModelScope.launch { //launch new coroutine to avoid blocking main thread
            repo.delete(TeacherCourseCrossRef(representedTeacher.teacherID, course.courseID))
        }
    }
}