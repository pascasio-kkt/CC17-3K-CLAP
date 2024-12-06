package com.example.bluewave.ui.category

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.bluewave.R
import com.google.android.material.button.MaterialButton

class EditProfileActivity : AppCompatActivity() {

    private lateinit var etName: EditText
    private lateinit var etContact: EditText
    private lateinit var etEmail: EditText
    private lateinit var etAddress: EditText
    private lateinit var tvFeedback: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.edit_profile_activity)

        etName = findViewById(R.id.etName)
        etContact = findViewById(R.id.etContact)
        etEmail = findViewById(R.id.etEmail)
        etAddress = findViewById(R.id.etAddress)
        tvFeedback = findViewById(R.id.tvFeedback)

        val backButton = findViewById<ImageButton>(R.id.backButton)
        val saveButton = findViewById<MaterialButton>(R.id.saveButton)
        val changePasswordButton = findViewById<MaterialButton>(R.id.changePasswordButton)
        val deleteAccountButton = findViewById<MaterialButton>(R.id.deleteAccountButton)

        val sharedPref = getSharedPreferences("UserData", Context.MODE_PRIVATE)
        loadProfileData(sharedPref)

        backButton.setOnClickListener {
            finish()
        }

        saveButton.setOnClickListener {
            saveProfileData(sharedPref)
        }

        changePasswordButton.setOnClickListener {
            changePassword()
        }

        deleteAccountButton.setOnClickListener {
            deleteAccount(sharedPref)
        }
    }

    private fun loadProfileData(sharedPref: SharedPreferences) {
        val userName = sharedPref.getString("full_name", "")
        val userContact = sharedPref.getString("contact", "")
        val userEmail = sharedPref.getString("email", "")
        val userAddress = sharedPref.getString("address", "")

        etName.setText(userName)
        etContact.setText(userContact)
        etEmail.setText(userEmail)
        etAddress.setText(userAddress)
    }

    private fun saveProfileData(sharedPref: SharedPreferences) {
        val editor = sharedPref.edit()

        val newName = etName.text.toString()
        val newContact = etContact.text.toString()
        val newEmail = etEmail.text.toString()
        val newAddress = etAddress.text.toString()

        if (newName.isBlank() || newContact.isBlank() || newEmail.isBlank() || newAddress.isBlank()) {
            tvFeedback.text = getString(R.string.error_empty_fields)
            tvFeedback.visibility = TextView.VISIBLE
            return
        }

        editor.putString("full_name", newName)
        editor.putString("contact", newContact)
        editor.putString("email", newEmail)
        editor.putString("address", newAddress)
        editor.apply()

        Toast.makeText(this, "Profile updated successfully", Toast.LENGTH_SHORT).show()
        finish()
    }

    private fun changePassword() {
        Toast.makeText(this, "Password change feature is under construction", Toast.LENGTH_SHORT).show()
    }

    private fun deleteAccount(sharedPref: SharedPreferences) {
        val editor = sharedPref.edit()
        editor.clear()
        editor.apply()

        Toast.makeText(this, "Account deleted successfully", Toast.LENGTH_SHORT).show()
        finish()
    }
}
