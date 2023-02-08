package com.example.p6_form

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fname = findViewById<TextView>(R.id.fname)
        val lname = findViewById<TextView>(R.id.lname)
        val phone = findViewById<TextView>(R.id.phone)
        val email = findViewById<TextView>(R.id.email)
        val datePicker = findViewById<DatePicker>(R.id.date_Picker)
        val gender= findViewById<Spinner>(R.id.gender)
        val address = findViewById<TextView>(R.id.address)
        val submit = findViewById<Button>(R.id.submitbtn)


        datePicker.maxDate = System.currentTimeMillis();
        val today = Calendar.getInstance()


        submit.setOnClickListener {
            val g = gender.selectedItem.toString()
            val day = datePicker.dayOfMonth
            val month = datePicker.month + 1
            val year = datePicker.year
            val selectedDate = "$day/$month/$year"
            if(fname.text != null && lname.text != null && phone.text != null && email.text != null && g != "Prefer Not to Say" && address != null){
                val intent = Intent(this@MainActivity,MainActivity2::class.java)
                intent.putExtra("values","First Name: "+fname.text+"\nLastName: "+lname.text+"\nPhone: "+phone.text+"\nEmail: "+email.text+"\nBirthday: "+selectedDate+"\nGender: "+g+"\nAddress: "+address.text)
                intent.putExtra("name",""+fname.text+" "+lname.text)
                startActivity(intent)
            }else{
                Toast.makeText(this@MainActivity, "Enter All Fields To Continue", Toast.LENGTH_SHORT).show()
            }


        }
//        datePicker.getDatePicker().setMaxDate(today.getTimeInMillis());
//        datePicker.init(today.get(Calendar.YEAR), today.get(Calendar.MONTH),
//            today.get(Calendar.DAY_OF_MONTH)) { view, year, month, day ->
//            val month = month + 1
//            val msg = "You Selected: $day/$month/$year"
//            Toast.makeText(this@MainActivity, msg, Toast.LENGTH_SHORT).show()
//        }
    }
}