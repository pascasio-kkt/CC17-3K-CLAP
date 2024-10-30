package com.example.feedbackandreportingsystem.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.feedbackandreportingsystem.R
import com.example.feedbackandreportingsystem.model.StatusUpdate
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class StatusHistoryAdapter : ListAdapter<StatusUpdate, StatusHistoryAdapter.StatusUpdateViewHolder>(
    StatusUpdateDiffCallback()
) {
    class StatusUpdateViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val oldStatusText: TextView = view.findViewById(R.id.textViewOldStatus)
        private val newStatusText: TextView = view.findViewById(R.id.textViewNewStatus)
        private val timestampText: TextView = view.findViewById(R.id.textViewTimestamp)
        private val commentText: TextView = view.findViewById(R.id.textViewComment)

        fun bind(statusUpdate: StatusUpdate) {
            oldStatusText.text = "Previous: ${statusUpdate.oldStatus}"
            newStatusText.text = "Updated to: ${statusUpdate.newStatus}"
            timestampText.text = formatDate(statusUpdate.timestamp)
            commentText.text = statusUpdate.comment ?: "No comment"
        }

        private fun formatDate(timestamp: Long): String {
            return SimpleDateFormat("MMM dd, yyyy HH:mm", Locale.getDefault())
                .format(Date(timestamp))
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StatusUpdateViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.status_update_item, parent, false)
        return StatusUpdateViewHolder(view)
    }

    override fun onBindViewHolder(holder: StatusUpdateViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

private class StatusUpdateDiffCallback : DiffUtil.ItemCallback<StatusUpdate>() {
    override fun areItemsTheSame(oldItem: StatusUpdate, newItem: StatusUpdate): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: StatusUpdate, newItem: StatusUpdate): Boolean {
        return oldItem == newItem
    }
}

