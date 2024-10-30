package com.example.feedbackandreportingsystem

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.feedbackandreportingsystem.databinding.ActivityMainBinding
import com.example.feedbackandreportingsystem.model.Report
import com.example.feedbackandreportingsystem.model.ReportSubmissionState
import com.example.feedbackandreportingsystem.viewmodel.MainViewModel
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import com.example.feedbackandreportingsystem.ui.adapter.ReportAdapter

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()
    private lateinit var reportsAdapter: ReportAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupUI()
        observeViewModel()
    }

    private fun setupUI() {
        setupReportTypeSpinner()
        setupRecyclerView()
        setupSubmitButton()
        setupUpdateStatusButton()
    }

    private fun setupReportTypeSpinner() {
        val reportTypes = arrayOf("Water Quality", "Leak", "Infrastructure", "Other")
        val adapter = ArrayAdapter(this, R.layout.dropdown_item, reportTypes)
        binding.autoCompleteTextView.setAdapter(adapter)
        binding.autoCompleteTextView.setText("", false)
    }

    private fun setupRecyclerView() {
        reportsAdapter = ReportAdapter(
            reports = emptyList(),
            onItemClick = { report: Report -> showReportDetails(report) }
        )
        binding.recyclerViewReports.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = reportsAdapter
        }
    }

    private fun setupSubmitButton() {
        binding.buttonSubmit.setOnClickListener { submitReport() }
    }

    private fun setupUpdateStatusButton() {
        binding.buttonUpdateStatus.setOnClickListener { updateReportStatus() }
    }

    private fun submitReport() {
        val type = binding.autoCompleteTextView.text.toString()
        val description = binding.editTextDescription.text.toString()

        if (validateInput(type, description)) {
            viewModel.submitReport(type, description)
        }
    }

    private fun validateInput(type: String, description: String): Boolean {
        var isValid = true
        if (type.isBlank()) {
            binding.reportTypeLayout.error = "Report type is required."
            isValid = false
        } else {
            binding.reportTypeLayout.error = null
        }

        if (description.isBlank()) {
            binding.descriptionLayout.error = "Description is required."
            isValid = false
        } else {
            binding.descriptionLayout.error = null
        }

        return isValid
    }

    private fun observeViewModel() {
        viewModel.reports.observe(this) { reports -> reportsAdapter.updateReports(reports) }

        viewModel.reportSubmissionState.observe(this) { state ->
            when (state) {
                is ReportSubmissionState.Submitted -> showSubmissionConfirmation()
                is ReportSubmissionState.Error -> showSubmissionError(state.message)
            }
        }
    }

    private fun showReportDetails(report: Report) {
        MaterialAlertDialogBuilder(this)
            .setTitle(report.type)
            .setMessage("Description: ${report.description}\nStatus: ${report.status.name}")
            .setPositiveButton("Delete") { _, _ -> deleteReport(report) } // Added delete option
            .setNegativeButton("Close") { dialog, _ -> dialog.dismiss() }
            .show()
    }

    private fun deleteReport(report: Report) {
        viewModel.deleteReport(report) // Call to ViewModel to delete report
        showSnackbar("Report deleted.")
    }

    private fun showSnackbar(message: String) {
        Snackbar.make(binding.root, message, Snackbar.LENGTH_SHORT).show()
    }

    private fun showSubmissionConfirmation() {
        showSnackbar("Your report has been submitted!")
    }

    private fun showSubmissionError(message: String) {
        showSnackbar("Error: $message")
    }

    private fun updateReportStatus() {
        val selectedReport = reportsAdapter.getSelectedReport() // This should return a valid report object

        if (selectedReport != null) {
            val statuses = Report.Status.entries // Updated to use entries
            MaterialAlertDialogBuilder(this)
                .setTitle("Update Status")
                .setItems(statuses.map { it.name }.toTypedArray()) { _, which ->
                    val newStatus = statuses[which]
                    viewModel.updateReportStatus(selectedReport.id, newStatus) // Ensure this is now Long
                    showSnackbar("Status updated to ${newStatus.name}.")
                }
                .setNegativeButton("Cancel") { dialog, _ -> dialog.dismiss() }
                .show()
        } else {
            showSnackbar("Please select a report to update its status.")
        }
    }
}
