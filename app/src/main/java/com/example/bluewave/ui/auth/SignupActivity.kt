package com.example.bluewave.ui.auth

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.bluewave.R
import com.example.bluewave.ui.category.AccountManagementFragment
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val fullNameEditText = findViewById<TextInputEditText>(R.id.full_name)
        val emailEditText = findViewById<TextInputEditText>(R.id.email_address)
        val createPasswordEditText = findViewById<TextInputEditText>(R.id.create_password)
        val confirmPasswordEditText = findViewById<TextInputEditText>(R.id.confirm_password)
        val signUpButton = findViewById<MaterialButton>(R.id.sign_up_button2)

        signUpButton.setOnClickListener {
            val fullName = fullNameEditText.text.toString()
            val email = emailEditText.text.toString()
            val createPassword = createPasswordEditText.text.toString()
            val confirmPassword = confirmPasswordEditText.text.toString()

            if (fullName.isEmpty() || email.isEmpty() || createPassword.isEmpty() || confirmPassword.isEmpty()) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            } else if (createPassword != confirmPassword) {
                Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show()
            } else {
                val sharedPref = getSharedPreferences("UserData", Context.MODE_PRIVATE)
                with(sharedPref.edit()) {
                    putString("full_name", fullName)
                    putString("email", email)
                    putString("password", createPassword)
                    apply()
                }

                val intent = Intent(this, AccountManagementFragment::class.java)
                startActivity(intent)
                finish()
            }
        }

        findViewById<TextView>(R.id.already_have_account).setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}
