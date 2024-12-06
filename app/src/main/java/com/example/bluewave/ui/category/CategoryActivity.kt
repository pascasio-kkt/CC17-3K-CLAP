package com.example.bluewave.ui.category

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.bluewave.R

class CategoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_categories)

        findViewById<ImageView>(R.id.arrow_back).setOnClickListener {
            finish()
        }
        findViewById<LinearLayout>(R.id.water_usage).setOnClickListener {
            startActivity(Intent(this, WaterUsageFragment::class.java))
        }

        findViewById<LinearLayout>(R.id.water_quality_reporting).setOnClickListener {
            startActivity(Intent(this, WaterReportFragment::class.java))
        }

        findViewById<LinearLayout>(R.id.account_management).setOnClickListener {
            startActivity(Intent(this, AccountManagementFragment::class.java))
        }

        findViewById<LinearLayout>(R.id.maintenance_notifications).setOnClickListener {
            startActivity(Intent(this, MaintenanceNotificationFragment::class.java))
        }

        findViewById<LinearLayout>(R.id.conservation_tips).setOnClickListener {
            startActivity(Intent(this, ConservationTipsFragment::class.java))
        }
    }
}
