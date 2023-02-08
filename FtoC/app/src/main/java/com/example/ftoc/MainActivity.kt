package com.example.ftoc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val convertBtn = findViewById<Button>(R.id.convertBtn)
        var fNumber = findViewById<TextView>(R.id.fNumber)
        var cNumber = findViewById<TextView>(R.id.cNumber)
        convertBtn.setOnClickListener{
            val fval = fNumber.text.toString()
            val cval = cNumber.text.toString()
            if(fval == ""  && cval == ""){
                Toast.makeText(this, "Enter atleast one value!", Toast.LENGTH_SHORT).show()
            }else if(fval.toString() != "" ){
                var cel = (fval.toInt()-32)*5/9
                cNumber.text = cel.toString()
            }else{
                var f = (cval.toInt()*9/5)+32
                fNumber.text = f.toString()
            }
        }
    }
}