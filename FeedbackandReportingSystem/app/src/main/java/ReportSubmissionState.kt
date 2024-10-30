
package com.example.feedbackandreportingsystem.model

sealed interface ReportSubmissionState {
    object Submitted : ReportSubmissionState
    data class Error(val message: String) : ReportSubmissionState
}
