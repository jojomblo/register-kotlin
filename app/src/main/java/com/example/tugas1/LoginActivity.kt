package com.example.tugas1
//Jonathan Aditya Vandra 672022006
//Tugas 2 Pemrograman Mobile

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.tugas1.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private var registeredUsername: String? = null
    private var registeredPassword: String? = null
    private var registeredName: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Retrieve data from RegisterActivity
        registeredUsername = intent.getStringExtra("username")
        registeredPassword = intent.getStringExtra("password")
        registeredName = intent.getStringExtra("name")

        binding.btnLogin.setOnClickListener {
            val username = binding.etUsername.text.toString().trim()
            val password = binding.etPassword.text.toString()

            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "All fields are required", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (username == registeredUsername && password == registeredPassword) {
                val intent = Intent(this, HomeActivity::class.java)
                intent.putExtra("name", registeredName)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Invalid username or password", Toast.LENGTH_SHORT).show()
            }
        }
    }
}