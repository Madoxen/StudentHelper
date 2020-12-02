package com.example.sqlite_example.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.studenthelper.model.*

@Database(
    entities = [Student::class, Course::class, CourseStudentCrossRef::class],
    version = 4,
    exportSchema = false
)
abstract class StudentHelperDatabase : RoomDatabase() {

    abstract fun studentDao(): StudentDAO
    abstract fun courseDao(): CourseDAO
    abstract fun courseStudentDao(): CourseWithStudentsDAO


    //INFO: Singleton?
    companion object {
        @Volatile
        private var INSTANCE: StudentHelperDatabase? = null

        fun getDatabase(context: Context): StudentHelperDatabase {
            val tempInstance = INSTANCE

            if (tempInstance != null)
                return tempInstance
            else
                synchronized(this)
                {
                    val instance = Room.databaseBuilder(
                        context.applicationContext,
                        StudentHelperDatabase::class.java,
                        "my_database"
                    ).fallbackToDestructiveMigration().build()
                    INSTANCE = instance
                    return instance

                }


        }


    }
}