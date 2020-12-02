package com.example.studenthelper.VM

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import com.example.sqlite_example.model.StudentHelperDatabase
import com.example.studenthelper.model.Mark
import com.example.studenthelper.model.repos.MarkRepo
import java.util.*

class ReportViewModel(application: Application) : AndroidViewModel(application){
    val calendar_today = Calendar.getInstance().also { c -> c.set(Calendar.HOUR_OF_DAY, 0); c.set(Calendar.MINUTE, 0); c.set(Calendar.SECOND, 0); c.set(Calendar.MILLISECOND, 0) }
    val repo = MarkRepo(StudentHelperDatabase.getDatabase(application).markDao())
    private val allMarks = repo.readAll;
    var todaysMarks : LiveData<List<Mark>> = Transformations.map(allMarks) { mark -> Log.d("asdasdas", calendar_today.toString());mark.filterNot { x -> x.date.before(calendar_today.time )} }

    init {
        allMarks.observeForever {  }
    }
}