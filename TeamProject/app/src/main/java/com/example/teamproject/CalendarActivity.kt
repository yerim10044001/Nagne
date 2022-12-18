package com.example.teamproject

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.teamproject.databinding.ActivityCalendarBinding
import com.example.teamproject.databinding.ActivityMainBinding

class CalendarActivity : AppCompatActivity() {
    lateinit var binding : ActivityCalendarBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCalendarBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

    }

}