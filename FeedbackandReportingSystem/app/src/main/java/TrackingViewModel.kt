package com.example.feedbackandreportingsystem.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.feedbackandreportingsystem.data.repository.ReportRepository
import com.example.feedbackandreportingsystem.model.StatusUpdate
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TrackingViewModel @Inject constructor(
    private val repository: ReportRepository
) : ViewModel() {

    fun getStatusUpdates(reportId: Long): LiveData<List<StatusUpdate>> {
        return repository.getStatusUpdates(reportId)
    }
}