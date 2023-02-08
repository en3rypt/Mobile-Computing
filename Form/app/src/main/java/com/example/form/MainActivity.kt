package com.example.form

import android.app.DatePickerDialog
import android.icu.util.Calendar
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Phone
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fname = findViewById<TextView>(R.id.fname)
        val lname = findViewById<TextView>(R.id.lname)
        val phone = findViewById<TextView>(R.id.phone)
        val email = findViewById<TextView>(R.id.email)
        val birthday = findViewById<DatePicker>(R.id.datePicker1)
Z

        val gender   = findViewById<Spinner>(R.id.gender)
        val address = findViewById<TextView>(R.id.address)
        val submit =  findViewById<Button>(R.id.submitbtn)

        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)


        val today = Calendar.getInstance()
        birthday.getDatePicker()


    }
}
