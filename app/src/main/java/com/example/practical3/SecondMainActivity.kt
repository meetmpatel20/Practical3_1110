package com.example.practical3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.core.view.WindowCompat
import com.example.practical3.databinding.ActivityMainBinding
import com.example.practical3.databinding.ActivitySecondMainBinding
class SecondMainActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondMainBinding
    lateinit var login_link: TextView
    override fun onCreate(savedInstanceState: Bundle?) {

        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_main)

        login_link = findViewById(R.id.link_login)
        login_link.setOnClickListener{
            intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

        // navigation menu
        binding = ActivitySecondMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.bottomNavigation.selectedItemId = R.id.registration
        binding.bottomNavigation.setOnNavigationItemSelectedListener { it1 ->
            when (it1.itemId) {
                R.id.login -> {
                    Intent(this, MainActivity::class.java).also {
                        startActivity(it)
                    }
                }
            }
            return@setOnNavigationItemSelectedListener true
        }
    }
}