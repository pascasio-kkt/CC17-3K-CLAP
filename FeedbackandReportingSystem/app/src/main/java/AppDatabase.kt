package com.example.feedbackandreportingsystem.data

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import android.content.Context
import com.example.feedbackandreportingsystem.data.dao.ReportDao
import com.example.feedbackandreportingsystem.model.Report
import com.example.feedbackandreportingsystem.model.StatusUpdate

@Database(entities = [Report::class, StatusUpdate::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun reportDao(): ReportDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "feedback_and_reporting_system"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
