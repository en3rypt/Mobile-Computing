package com.example.p6_form

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        val display = findViewById<TextView>(R.id.displayValue)
        val home = findViewById<Button>(R.id.homeBtn)

        val bundle = intent.extras
        val name = bundle?.get("name")

        display.text = "Thank you "+name+" for submitting the form"

        home.setOnClickListener {
            val intent = Intent(this@MainActivity3,MainActivity::class.java)
            startActivity(intent)
            finishAffinity()

        }


    }
}