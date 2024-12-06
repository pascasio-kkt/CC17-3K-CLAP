package com.example.bluewave.ui.auth

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.bluewave.R
import com.example.bluewave.ui.category.AccountManagementFragment
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class LoginActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                onBackPressedAction()
            }
        })

        toolbar.setNavigationOnClickListener {
            onBackPressedAction()
        }

        val emailEditText = findViewById<TextInputEditText>(R.id.email_address)
        val passwordEditText = findViewById<TextInputEditText>(R.id.password) // Make sure the ID matches your layout

        val loginButton = findViewById<MaterialButton>(R.id.login_button)
        loginButton.setOnClickListener {
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()

            // Simple validation and message display
            when {
                email.isEmpty() -> {
                    Toast.makeText(this, "Please enter your email address", Toast.LENGTH_SHORT).show()
                }
                password.isEmpty() -> {
                    Toast.makeText(this, "Please enter your password", Toast.LENGTH_SHORT).show()
                }
                else -> {
                    val sharedPref = getSharedPreferences("UserData", Context.MODE_PRIVATE)
                    val storedEmail = sharedPref.getString("email", null)
                    val storedPassword = sharedPref.getString("password", null)

                    if (email == storedEmail && password == storedPassword) {
                        val intent = Intent(this, AccountManagementFragment::class.java)
                        startActivity(intent)
                        finish()
                    } else {
                        Toast.makeText(this, "Invalid email or password", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }

        val signUpTextView = findViewById<TextView>(R.id.sign_up)
        signUpTextView.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }

        val signInTextView = findViewById<TextView>(R.id.already_have_account)
        signInTextView.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
    }

    private fun onBackPressedAction() {
        super.onBackPressedDispatcher.onBackPressed()
    }
}
