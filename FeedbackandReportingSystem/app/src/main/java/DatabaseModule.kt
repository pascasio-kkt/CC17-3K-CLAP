package com.example.feedbackandreportingsystem.di

import android.content.Context
import androidx.room.Room
import com.example.feedbackandreportingsystem.data.AppDatabase
import com.example.feedbackandreportingsystem.data.dao.ReportDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "your_database_name" // Replace with your actual database name
        ).fallbackToDestructiveMigration() // Optional: Depending on your needs
            .build()
    }

    @Provides
    fun provideReportDao(appDatabase: AppDatabase): ReportDao {
        return appDatabase.reportDao() // Provide ReportDao instance
    }
}
