package com.example.greenpractices

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class GreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val cardView1 = findViewById<CardView>(R.id.cardView1)
        val cardView2 = findViewById<CardView>(R.id.cardView2)
        val cardView3 = findViewById<CardView>(R.id.cardView3)
        val arrowButton =findViewById<ImageView>(R.id.arrowButton)

        cardView1.setOnClickListener {
            navigateToWaterUsage()
        }

        cardView2.setOnClickListener {
            navigateToWasteManagement()
        }

        cardView3.setOnClickListener {
            navigateToEnergyEfficiency()
        }

        arrowButton.setOnClickListener {
            navigateToDashboard()
        }
    }

    private fun navigateToWaterUsage() {
        val intent = Intent(this, WaterUsageActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToWasteManagement() {
        val intent = Intent(this, WasteManagementActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToEnergyEfficiency() {
        val intent = Intent(this, EnergyEfficiencyActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToDashboard() {
        val intent = Intent(this, DashboardActivity::class.java)
        startActivity(intent)
    }
}
