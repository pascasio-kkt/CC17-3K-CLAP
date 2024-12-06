package com.example.bluewave.ui.welcome

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.bluewave.R.*

class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.welcome_activity)

        val welcomeTextView = findViewById<TextView>(id.welcome_text)
        welcomeTextView.text = getString(string.welcome)

        val introMessageView = findViewById<TextView>(id.intro_message)
        introMessageView.text = getString(string.intro_message)

        val welcomeImageView = findViewById<ImageView>(id.welcome_image)
        welcomeImageView.setImageDrawable(ContextCompat.getDrawable(this, drawable.logo))

        val signInButton = findViewById<Button>(id.sign_in_button)
        signInButton.setOnClickListener {
            // TODO: Navigate to sign-in screen
        }

        val signUpButton = findViewById<Button>(id.sign_up_button)
        signUpButton.setOnClickListener {
            // TODO: Navigate to sign-up screen
        }
    }
}
