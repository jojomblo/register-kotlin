package com.example.tugas1
//Jonathan Aditya Vandra 672022006
//Tugas 2 Pemrograman Mobile

    import android.content.Intent
    import android.os.Bundle
    import androidx.appcompat.app.AppCompatActivity
    import com.example.tugas1.databinding.ActivityHomeBinding

    class HomeActivity : AppCompatActivity() {

        private lateinit var binding: ActivityHomeBinding

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding = ActivityHomeBinding.inflate(layoutInflater)
            setContentView(binding.root)

            val name = intent.getStringExtra("name")
            binding.tvWelcome.text = "Welcome $name"

            // Handle logout button click
            binding.btnLogout.setOnClickListener {
                val intent = Intent(this, RegisterActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }