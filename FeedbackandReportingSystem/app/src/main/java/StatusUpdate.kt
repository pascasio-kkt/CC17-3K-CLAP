package com.example.feedbackandreportingsystem.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "status_updates",
    foreignKeys = [ForeignKey(
        entity = Report::class,
        parentColumns = ["id"],
        childColumns = ["reportId"],
        onDelete = ForeignKey.CASCADE
    )]
)
data class StatusUpdate(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    @ColumnInfo(name = "reportId", index = true)
    val reportId: Long,
    val oldStatus: Report.Status,
    val newStatus: Report.Status,
    val timestamp: Long = System.currentTimeMillis(),
    val comment: String?
)
