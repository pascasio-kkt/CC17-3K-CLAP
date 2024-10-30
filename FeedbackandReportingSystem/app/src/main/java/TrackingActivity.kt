package com.example.feedbackandreportingsystem.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.feedbackandreportingsystem.R
import com.example.feedbackandreportingsystem.adapter.StatusUpdateAdapter
import com.example.feedbackandreportingsystem.databinding.ActivityTrackingBinding
import com.example.feedbackandreportingsystem.viewmodel.TrackingViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TrackingActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTrackingBinding
    private lateinit var statusUpdateAdapter: StatusUpdateAdapter
    private val viewModel: TrackingViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTrackingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupToolbar()
        setupRecyclerView()
        displayReportDetails()
        observeStatusUpdates()
    }

    private fun setupToolbar() {
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        binding.toolbar.setNavigationOnClickListener {
            finish()
        }
    }

    private fun setupRecyclerView() {
        statusUpdateAdapter = StatusUpdateAdapter()
        binding.recyclerViewStatusUpdates.apply {
            layoutManager = LinearLayoutManager(this@TrackingActivity)
            adapter = statusUpdateAdapter
        }
    }

    private fun displayReportDetails() {
        val reportId = intent.getLongExtra("REPORT_ID", -1)
        val reportType = intent.getStringExtra("REPORT_TYPE") ?: ""
        val reportDescription = intent.getStringExtra("REPORT_DESCRIPTION") ?: ""
        val reportStatus = intent.getStringExtra("REPORT_STATUS") ?: ""

        binding.apply {
            textViewTrackingId.text = getString(R.string.report_number, reportId)
            textViewTrackingType.text = reportType
            textViewTrackingDescription.text = reportDescription
            textViewTrackingStatus.text = reportStatus
        }
    }

    private fun observeStatusUpdates() {
        val reportId = intent.getLongExtra("REPORT_ID", -1)
        viewModel.getStatusUpdates(reportId).observe(this) { updates ->
            statusUpdateAdapter.setUpdates(updates)
        }
    }

}