package com.example.sqlite_example.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.studenthelper.model.*
import java.security.AccessControlContext

@Database(entities = [Student::class, Course::class], version = 1, exportSchema = false)
abstract class MyDatabase : RoomDatabase() {

    abstract fun studentDao(): StudentDAO
    abstract fun courseDao(): CourseDAO
    abstract fun courseWithStudentsDao(): CourseWithStudentsDAO;

    //INFO: Singleton?
    companion object{
        @Volatile
        private var INSTANCE: MyDatabase?=null

        fun getDatabase(context: Context):MyDatabase{
            val tempInstance=INSTANCE

            if(tempInstance!=null)
                return tempInstance
            else
                synchronized(this)
                {
                    val instance= Room.databaseBuilder(
                        context.applicationContext,
                        MyDatabase::class.java,
                        "my_database"
                    ).build()
                    INSTANCE=instance
                    return instance

                }


        }


    }
}