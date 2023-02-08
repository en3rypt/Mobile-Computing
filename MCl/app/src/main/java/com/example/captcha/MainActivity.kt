package com.example.captcha

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val submitBtn = findViewById<Button>(R.id.submit)
        submitBtn.setBackgroundColor(getColor(R.color.orange))
    }
}