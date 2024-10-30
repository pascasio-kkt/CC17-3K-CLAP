package com.example.feedbackandreportingsystem.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.feedbackandreportingsystem.R
import com.example.feedbackandreportingsystem.model.Report
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class ReportAdapter(
    private var reports: List<Report>,
    private val onItemClick: (Report) -> Unit
) : RecyclerView.Adapter<ReportAdapter.ReportViewHolder>() {

    private var selectedReport: Report? = null // Variable to hold the selected report

    inner class ReportViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(report: Report) {
            itemView.findViewById<TextView>(R.id.textViewType).text = report.type
            itemView.findViewById<TextView>(R.id.textViewDescription).text = report.description
            itemView.findViewById<TextView>(R.id.textViewStatus).text = report.status.name
            itemView.findViewById<TextView>(R.id.textViewTimestamp).text = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Date(report.timestamp))

            itemView.setOnClickListener {
                selectedReport = report // Set selected report
                onItemClick(report)
                notifyDataSetChanged() // Refresh the adapter to reflect selection change
            }

            // Highlight selected report
            itemView.isSelected = (selectedReport == report)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReportViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.report_item_layout, parent, false)
        return ReportViewHolder(view)
    }

    override fun onBindViewHolder(holder: ReportViewHolder, position: Int) {
        holder.bind(reports[position])
    }

    override fun getItemCount(): Int = reports.size

    fun getSelectedReport(): Report? {
        return selectedReport
    }

    fun updateReports(newReports: List<Report>) {
        reports = newReports
        selectedReport = null // Clear selection when updating
        notifyDataSetChanged()
    }
}