package com.example.feedbackandreportingsystem.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.feedbackandreportingsystem.data.repository.ReportRepository
import com.example.feedbackandreportingsystem.model.Report
import com.example.feedbackandreportingsystem.model.ReportSubmissionState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: ReportRepository
) : ViewModel() {

    val reports: LiveData<List<Report>> = repository.reports

    private val _reportSubmissionState = MutableLiveData<ReportSubmissionState>()
    val reportSubmissionState: LiveData<ReportSubmissionState> = _reportSubmissionState

    fun submitReport(type: String, description: String) {
        viewModelScope.launch {
            try {
                repository.submitReport(type, description)
                _reportSubmissionState.value = ReportSubmissionState.Submitted
            } catch (e: Exception) {
                _reportSubmissionState.value = ReportSubmissionState.Error(e.message ?: "Unknown error occurred")
            }
        }
    }

    fun deleteReport(report: Report) {
        viewModelScope.launch {
            repository.deleteReport(report)
        }
    }

    fun updateReportStatus(reportId: Long, newStatus: Report.Status) {
        viewModelScope.launch {
            try {
                repository.updateReportStatus(reportId, newStatus)
            } catch (e: Exception) {
                e.printStackTrace()  // Logging the exception
            }
        }
    }


}
