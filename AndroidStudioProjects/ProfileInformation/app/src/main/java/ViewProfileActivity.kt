package com.example.profileinformation

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import android.widget.ImageView


class ViewProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_profile)

        // Set up the back button listener
        val backButton = findViewById<ImageView>(R.id.backButton)
        backButton.setOnClickListener {
            finish() // This will close the current activity
        }
    }

    fun onEditProfileClicked(view: View) {
        Toast.makeText(this, "Edit Profile clicked", Toast.LENGTH_SHORT).show()
        // Add your logic for editing the profile here
    }
}
