package com.example.feedbackandreportingsystem.adapter

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

class StatusUpdateAdapter : ListAdapter<StatusUpdate, StatusUpdateAdapter.ViewHolder>(StatusUpdateDiffCallback()) {

    fun setUpdates(updates: List<StatusUpdate>) {
        submitList(updates)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val oldStatusText: TextView = itemView.findViewById(R.id.textViewOldStatus)
        private val newStatusText: TextView = itemView.findViewById(R.id.textViewNewStatus)
        private val commentText: TextView = itemView.findViewById(R.id.textViewComment)
        private val timestampText: TextView = itemView.findViewById(R.id.textViewTimestamp)

        fun bind(update: StatusUpdate) {
            oldStatusText.text = itemView.context.getString(R.string.status_previous, update.oldStatus.toString())
            newStatusText.text = itemView.context.getString(R.string.status_updated, update.newStatus.toString())
            commentText.text = update.comment ?: itemView.context.getString(R.string.no_comment)
            timestampText.text = formatDate(update.timestamp)
        }

        private fun formatDate(timestamp: Long): String {
            return SimpleDateFormat("MMM dd, yyyy HH:mm", Locale.getDefault())
                .format(Date(timestamp))
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.status_update_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
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