package com.example.sqlite_example.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.studenthelper.model.*

@Database(entities = [Student::class, Course::class, Teacher::class, TeacherCourseCrossRef::class], version = 2, exportSchema = false)
abstract class StudentHelperDatabase : RoomDatabase() {

    abstract fun studentDao(): StudentDAO
    abstract fun courseDao(): CourseDAO
    abstract fun teacherDao(): TeacherDAO
    abstract fun teacherCourseDao() : TeacherCourseDao

    //INFO: Singleton?
    companion object{
        @Volatile
        private var INSTANCE: StudentHelperDatabase?=null

        fun getDatabase(context: Context):StudentHelperDatabase{
            val tempInstance=INSTANCE

            if(tempInstance!=null)
                return tempInstance
            else
                synchronized(this)
                {
                    val instance= Room.databaseBuilder(
                        context.applicationContext,
                        StudentHelperDatabase::class.java,
                        "my_database"
                    ).fallbackToDestructiveMigration().build()
                    INSTANCE=instance
                    return instance

                }


        }




    }
}