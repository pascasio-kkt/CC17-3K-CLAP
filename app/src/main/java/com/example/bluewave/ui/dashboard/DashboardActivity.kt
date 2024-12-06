package com.example.bluewave.ui.dashboard

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.bluewave.R

class DashboardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dashboard_activity)
    }
    @Suppress("UNUSED_PARAMETER")
    fun onAllClick(view: View) {
        Toast.makeText(this, "All clicked", Toast.LENGTH_SHORT).show()
    }
    @Suppress("UNUSED_PARAMETER")

    fun onDailyClick(view: View) {
        Toast.makeText(this, "Daily clicked", Toast.LENGTH_SHORT).show()
    }
    @Suppress("UNUSED_PARAMETER")

    fun onMonthlyClick(view: View) {
        Toast.makeText(this, "Monthly clicked", Toast.LENGTH_SHORT).show()
    }
    @Suppress("UNUSED_PARAMETER")

    fun onYearlyClick(view: View) {
        Toast.makeText(this, "Yearly clicked", Toast.LENGTH_SHORT).show()
    }
    @Suppress("UNUSED_PARAMETER")

    fun onDailyUsageClick(view: View) {
        Toast.makeText(this, "Daily usage clicked", Toast.LENGTH_SHORT).show()
    }
    @Suppress("UNUSED_PARAMETER")

    fun onMonthlyUsageClick(view: View) {
        Toast.makeText(this, "Monthly usage clicked", Toast.LENGTH_SHORT).show()
    }
    @Suppress("UNUSED_PARAMETER")

    fun onYearlyUsageClick(view: View) {
        Toast.makeText(this, "Yearly usage clicked", Toast.LENGTH_SHORT).show()
    }
}