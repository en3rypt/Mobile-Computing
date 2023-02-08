package com.example.countryvisit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val bundle =  intent.extras
        val ss  = intent.getStringExtra("Value").toString()
        val textview = findViewById<TextView>(R.id.displayText)
        val backBtn = findViewById<Button>(R.id.backBtn)
        textview.setText(ss)
        backBtn.setOnClickListener{
//            intent = Intent(this,MainActivity::class.java)
//            startActivity(intent)
            finish()
        }
    }
}