package com.example.feedmoji

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn = findViewById<Button>(R.id.button)
        val hungry = findViewById<ImageView>(R.id.imageView)
        val full = findViewById<ImageView>(R.id.imageView2)
        val text = findViewById<TextView>(R.id.textView)
        var count =0
        btn.setOnClickListener{
            if(count%2 == 0){
                hungry.visibility = View.INVISIBLE
                full.visibility  = View.VISIBLE
                text.text = "I'm so full"
                btn.text = "Done"
            }else{
                hungry.visibility = View.VISIBLE
                full.visibility  = View.INVISIBLE
                text.text = "I'm so Hungry"
                btn.text = "Eat Cookie"
            }
            count++
        }
    }
}