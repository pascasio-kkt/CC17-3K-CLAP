package com.example.feedbackandreportingsystem.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
@Entity(tableName = "reports")
data class Report(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val type: String,
    val description: String,
    var status: Status = Status.SUBMITTED,
    val timestamp: Long = System.currentTimeMillis()
) : Parcelable {
    enum class Status {
        SUBMITTED,
        UNDER_REVIEW,
        IN_PROGRESS,
        RESOLVED
    }
}


