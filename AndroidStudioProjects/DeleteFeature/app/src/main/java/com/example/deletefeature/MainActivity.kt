package com.example.deletefeature

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {

    private lateinit var etName: EditText
    private lateinit var etEmail: EditText
    private lateinit var etContact: EditText
    private lateinit var etAddress: EditText
    private lateinit var saveButton: MaterialButton
    private lateinit var changePasswordButton: MaterialButton
    private lateinit var deleteAccountButton: MaterialButton
    private lateinit var backButton: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etName = findViewById(R.id.etName)
        etEmail = findViewById(R.id.etEmail)
        etContact = findViewById(R.id.etContact)
        etAddress = findViewById(R.id.etAddress)
        saveButton = findViewById(R.id.saveButton)
        changePasswordButton = findViewById(R.id.changePasswordButton)
        deleteAccountButton = findViewById(R.id.deleteAccountButton)
        backButton = findViewById(R.id.backButton)

        saveButton.setOnClickListener {
            val name = etName.text.toString()
            val email = etEmail.text.toString()
            val contact = etContact.text.toString()
            val address = etAddress.text.toString()

            if (name.isNotEmpty() && email.isNotEmpty() && contact.isNotEmpty() && address.isNotEmpty()) {
                Toast.makeText(this, "Profile saved!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Please fill in all fields!", Toast.LENGTH_SHORT).show()
            }
        }

        changePasswordButton.setOnClickListener {
            Toast.makeText(this, "Change Password clicked", Toast.LENGTH_SHORT).show()
        }

        deleteAccountButton.setOnClickListener {
            onDeleteAccountClicked(it)
        }

        backButton.setOnClickListener {
            finish()
        }
    }

    private fun onDeleteAccountClicked(view: View) {
        AlertDialog.Builder(this)
            .setTitle("Delete Account")
            .setMessage("Are you sure you want to delete your account? This action cannot be undone.")
            .setPositiveButton("Yes") { _, _ ->
                Toast.makeText(this, "Account deleted successfully", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("No", null)
            .show()
    }
}