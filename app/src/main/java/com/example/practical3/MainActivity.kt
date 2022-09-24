package com.example.practical3

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.resources.Compatibility.Api21Impl.inflate
import androidx.core.view.WindowCompat
import com.example.practical3.databinding.ActivitySecondMainBinding
import com.example.practical3.databinding.ActivitySecondMainBinding.inflate
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.widget.Toolbar
import com.example.practical3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var signup_link: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        signup_link = findViewById(R.id.link_signup)
        signup_link.setOnClickListener{
            intent = Intent(this,SecondMainActivity::class.java)
            startActivity(intent)
        }


        //navigation menu
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //setSupportActionBar(binding.toolbar)
        binding.bottomNavigation.selectedItemId = R.id.login
        binding.bottomNavigation.setOnNavigationItemSelectedListener { it1 ->
            when(it1.itemId){
                R.id.registration->
                {
                    Intent(this,SecondMainActivity::class.java).also {
                        startActivity(it)
                    }
                }

            }
            return@setOnNavigationItemSelectedListener true
        }
    }
}



