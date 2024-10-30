package com.example.feedbackandreportingsystem.data

import androidx.room.TypeConverter
import com.example.feedbackandreportingsystem.model.Report

class Converters {
    @TypeConverter
    fun fromStatus(value: Report.Status): String {
        return value.name
    }

    @TypeConverter
    fun toStatus(value: String): Report.Status {
        return Report.Status.valueOf(value)
    }
}
