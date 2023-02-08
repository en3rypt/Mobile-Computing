package com.example.rateapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RatingBar
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button =findViewById<Button>(R.id.button)
        val feedback = findViewById<TextView>(R.id.feedback)
        val rating = findViewById<RatingBar>(R.id.ratingBar)
        val ratingText = findViewById<TextView>(R.id.ratingText)

        val ratingMap = mapOf(1 to "Disappointed. Very poor", 2 to "Not good. Need improvement", 3 to "Satisfied.", 4 to "Good. Enjoyed it", 5 to "Awesome. I love it")
        rating.setOnRatingBarChangeListener { _, fl, _ ->
            ratingText.text = ratingMap.get(fl.toInt()).toString()
        }


        button.setOnClickListener{
            Toast.makeText(this,feedback.text.toString(),Toast.LENGTH_LONG).show()
        }
    }
}