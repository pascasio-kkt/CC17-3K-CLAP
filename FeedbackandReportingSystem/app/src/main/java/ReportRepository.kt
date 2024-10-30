package com.example.feedbackandreportingsystem.data.repository

import androidx.lifecycle.LiveData
import com.example.feedbackandreportingsystem.model.Report
import com.example.feedbackandreportingsystem.model.StatusUpdate

interface ReportRepository {
    val reports: LiveData<List<Report>>

    suspend fun submitReport(type: String, description: String): Report
    suspend fun getReportById(reportId: Long): Report?
    suspend fun deleteReport(report: Report)
    suspend fun updateReport(report: Report)
    fun getStatusUpdates(reportId: Long): LiveData<List<StatusUpdate>>

    // Choose one of the following based on your needs
    suspend fun updateReportStatus(reportId: Long, newStatus: Report.Status)
    // suspend fun updateReportStatus(reportId: String, newStatus: Report.Status)
    suspend fun addStatusUpdate(reportId: Long, oldStatus: Report.Status, newStatus: Report.Status, comment: String)
}
