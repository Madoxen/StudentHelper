package com.example.studenthelper.model.converters

import androidx.room.TypeConverter
import java.util.Date

public class DateConverter {

    @TypeConverter
    public fun toDate(timestamp : Long?) : Date?
    {
        return timestamp?.let { Date(it) };
    }

    @TypeConverter
    public fun fromDate(date: Date?): Long? {
        return date?.time;
    }
}