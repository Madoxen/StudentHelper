package com.example.studenthelper.model

import androidx.room.*
import com.example.studenthelper.model.converters.DateConverter
import java.util.Date


@Entity(
    tableName = "mark_table",
    foreignKeys = [ForeignKey(
        entity = CourseStudentCrossRef::class,
        parentColumns = ["ID"],
        childColumns = ["courseStudentID"],
        onDelete = ForeignKey.CASCADE
    )]
)
@TypeConverters(DateConverter::class)
data class Mark(
    @PrimaryKey(autoGenerate = true) val ID: Long,
    val courseStudentID: Long,
    val mark: Int,
    val note: String,
    val date: Date
)


