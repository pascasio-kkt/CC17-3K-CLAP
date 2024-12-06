package com.example.bluewave.ui.category

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.bluewave.R

class AccountManagementFragment : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_profile)

        val sharedPref = getSharedPreferences("UserData", Context.MODE_PRIVATE)
        val userName = sharedPref.getString("full_name", "")
        val userEmail = sharedPref.getString("email", "")
        val userPassword = sharedPref.getString("password", "")

        findViewById<TextView>(R.id.us_name).text = userName
        findViewById<TextView>(R.id.email_value).text = userEmail
        findViewById<TextView>(R.id.password_value).text = userPassword

        findViewById<ImageView>(R.id.backButton).setOnClickListener {
            finish()
        }

        findViewById<TextView>(R.id.editProfileButton).setOnClickListener {
            val intent = Intent(this, EditProfileActivity::class.java)
            startActivity(intent)
        }
    }
}
