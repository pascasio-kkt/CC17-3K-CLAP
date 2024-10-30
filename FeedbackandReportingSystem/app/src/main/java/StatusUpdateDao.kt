package com.example.feedbackandreportingsystem.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.feedbackandreportingsystem.model.StatusUpdate

@Dao
interface StatusUpdateDao {
    @Insert
    suspend fun insert(statusUpdate: StatusUpdate)

    @Query("SELECT * FROM status_updates WHERE reportId = :reportId")
    fun getStatusUpdatesForReport(reportId: Long): LiveData<List<StatusUpdate>>
}
