package com.example.studenthelper.model.repos;

import androidx.lifecycle.LiveData
import com.example.studenthelper.model.Mark
import com.example.studenthelper.model.MarkDAO

public class MarkRepo(private val markDao: MarkDAO) {

    val readAll: LiveData<List<Mark>> = markDao.all()

    suspend fun add(mark: Mark) {
        markDao.insert(mark)
    }

    suspend fun delete(mark: Mark)=markDao.delete(mark)
}
