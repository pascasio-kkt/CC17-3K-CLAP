package com.example.feedbackandreportingsystem.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import androidx.room.Delete
import com.example.feedbackandreportingsystem.model.Report
import com.example.feedbackandreportingsystem.model.StatusUpdate

@Dao
interface ReportDao {
    @Query("SELECT * FROM reports ORDER BY timestamp DESC")
    fun getReports(): LiveData<List<Report>>

    @Insert
    suspend fun insert(report: Report): Long

    @Query("SELECT * FROM reports WHERE id = :reportId")
    suspend fun getReportById(reportId: Long): Report?

    @Delete
    suspend fun deleteReport(report: Report)

    @Update
    suspend fun updateReport(report: Report)

    @Insert
    suspend fun insertStatusUpdate(statusUpdate: StatusUpdate)

    @Query("SELECT * FROM status_updates WHERE reportId = :reportId ORDER BY timestamp DESC")
    fun getStatusUpdatesForReport(reportId: Long): LiveData<List<StatusUpdate>>

    // New method to update only the status
    @Query("UPDATE reports SET status = :newStatus WHERE id = :reportId")
    suspend fun updateReportStatus(reportId: Long, newStatus: Report.Status)
}
