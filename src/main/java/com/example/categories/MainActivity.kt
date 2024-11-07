package com.example.categories

import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Correct the cast to ImageView instead of LinearLayout
        findViewById<ImageView>(R.id.menu_icon).setOnClickListener {
            Toast.makeText(this, "Menu clicked", Toast.LENGTH_SHORT).show()
            // Handle Menu click
        }

        findViewById<LinearLayout>(R.id.water_usage).setOnClickListener {
            Toast.makeText(this, "Water Usage clicked", Toast.LENGTH_SHORT).show()
            // Handle Water Usage click
        }

        findViewById<LinearLayout>(R.id.water_quality_reporting).setOnClickListener {
            Toast.makeText(this, "Water Quality Reporting clicked", Toast.LENGTH_SHORT).show()
            // Handle Water Quality Reporting click
        }

        findViewById<LinearLayout>(R.id.account_management).setOnClickListener {
            Toast.makeText(this, "Account Management clicked", Toast.LENGTH_SHORT).show()
            // Handle Account Management click
        }

        findViewById<LinearLayout>(R.id.maintenance_notifications).setOnClickListener {
            Toast.makeText(this, "Maintenance Notifications clicked", Toast.LENGTH_SHORT).show()
            // Handle Maintenance Notifications click
        }

        findViewById<LinearLayout>(R.id.conservation_tips).setOnClickListener {
            Toast.makeText(this, "Conservation Tips clicked", Toast.LENGTH_SHORT).show()
            // Handle Conservation Tips click
        }

        findViewById<LinearLayout>(R.id.user_feedback).setOnClickListener {
            Toast.makeText(this, "User Feedback clicked", Toast.LENGTH_SHORT).show()
            // Handle User Feedback click
        }
    }
}
