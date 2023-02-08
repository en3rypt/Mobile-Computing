package com.example.p6_form

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val display = findViewById<TextView>(R.id.display)
        val back = findViewById<Button>(R.id.back)
        val submit = findViewById<Button>(R.id.submit)

        val bundle = intent.extras
        val value = bundle?.get("values")


        display.text = value as CharSequence?
        val name = bundle?.get("name").toString()
        submit.setOnClickListener {
            val intent = Intent(this@MainActivity2,MainActivity3::class.java)
            intent.putExtra("name",name)
            startActivity(intent)
            finishAffinity()
        }
        back.setOnClickListener{
            finish()
        }

    }
}