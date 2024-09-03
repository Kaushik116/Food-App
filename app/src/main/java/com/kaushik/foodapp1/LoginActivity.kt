package com.kaushik.foodapp1

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.kaushik.foodapp1.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    lateinit var username: EditText
    lateinit var password: EditText
    lateinit var loginButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize views
        username = binding.username
        password = binding.password
        loginButton = binding.loginBtn

        loginButton.setOnClickListener(View.OnClickListener {
            val enteredUsername = username.text.toString()
            val enteredPassword = password.text.toString()

            // Check if the entered credentials match the saved credentials
            if (isValidCredentials(enteredUsername, enteredPassword)) {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                // Remove the finish() call to keep MainActivity in the back stack
                Toast.makeText(this, "Login Successful!!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Login Failed!", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun isValidCredentials(enteredUsername: String, enteredPassword: String): Boolean {
        val sharedPreferences = getSharedPreferences("login_prefs", Context.MODE_PRIVATE)
        val savedUsername = sharedPreferences.getString("username", "user")
        val savedPassword = sharedPreferences.getString("password", "1234")

        // Check if the entered credentials match the saved credentials
        return enteredUsername == savedUsername && enteredPassword == savedPassword
    }
}