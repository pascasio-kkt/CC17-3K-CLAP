package com.example.feedbackandreportingsystem.data.repository

import androidx.lifecycle.LiveData
import com.example.feedbackandreportingsystem.data.dao.ReportDao
import com.example.feedbackandreportingsystem.model.Report
import com.example.feedbackandreportingsystem.model.StatusUpdate
import javax.inject.Inject

class ReportRepositoryImpl @Inject constructor(
    private val reportDao: ReportDao
) : ReportRepository {
    override val reports: LiveData<List<Report>> = reportDao.getReports()

    override suspend fun submitReport(type: String, description: String): Report {
        val report = Report(
            type = type,
            description = description,
            status = Report.Status.SUBMITTED
        )
        val id = reportDao.insert(report)
        return report.copy(id = id)
    }

    override suspend fun getReportById(reportId: Long): Report? {
        return reportDao.getReportById(reportId)
    }

    override suspend fun deleteReport(report: Report) {
        reportDao.deleteReport(report)
    }

    override suspend fun updateReport(report: Report) {
        reportDao.updateReport(report)
    }

    override fun getStatusUpdates(reportId: Long): LiveData<List<StatusUpdate>> {
        return reportDao.getStatusUpdatesForReport(reportId)
    }

    // Implementing the updateReportStatus method
    override suspend fun updateReportStatus(reportId: Long, newStatus: Report.Status) {
        reportDao.updateReportStatus(reportId, newStatus)  // Call the method from ReportDao
    }

    override suspend fun addStatusUpdate(reportId: Long, oldStatus: Report.Status, newStatus: Report.Status, comment: String) {
        val statusUpdate = StatusUpdate(
            reportId = reportId,
            oldStatus = oldStatus,
            newStatus = newStatus,
            comment = comment
        )
        reportDao.insertStatusUpdate(statusUpdate)
    }
}
