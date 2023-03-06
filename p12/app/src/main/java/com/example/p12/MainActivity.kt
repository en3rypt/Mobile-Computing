package com.example.p12

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var database: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //from time selection
        val timeTextView = findViewById<TextView>(R.id.fromTime)
        timeTextView.setOnClickListener {
            val calendar = Calendar.getInstance()
            val hour = calendar.get(Calendar.HOUR_OF_DAY)
            val minute = calendar.get(Calendar.MINUTE)

            val timePickerDialog = TimePickerDialog(
                this,
                { _, selectedHour, selectedMinute ->
                    // Do something with the selected time (e.g. update the TextView text)
                    timeTextView.text = "$selectedHour:$selectedMinute"
                },
                hour,
                minute,
                false
            )
            timePickerDialog.show()
        }

            //to time selection
        val timeTextView2 = findViewById<TextView>(R.id.toTime)
        timeTextView2.setOnClickListener {
            val calendar = Calendar.getInstance()
            val hour = calendar.get(Calendar.HOUR_OF_DAY)
            val minute = calendar.get(Calendar.MINUTE)

            val timePickerDialog = TimePickerDialog(
                this,
                { _, selectedHour, selectedMinute ->
                    // Do something with the selected time (e.g. update the TextView text)
                    timeTextView2.text = "$selectedHour:$selectedMinute"
                },
                hour,
                minute,
                false
            )
            timePickerDialog.show()
        }

        //date selection
        val dateEditText = findViewById<EditText>(R.id.date)
        dateEditText.setOnClickListener {
            val calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)

            val datePickerDialog = DatePickerDialog(
                this,
                { _, selectedYear, selectedMonth, selectedDay ->
                    // Do something with the selected date (e.g. update the EditText text)
                    dateEditText.setText("$selectedDay/${selectedMonth + 1}/$selectedYear")
                },
                year,
                month,
                day
            )
            datePickerDialog.show()
        }

        //no of kids selection from radio group with id kids
        val radioGroup = findViewById<RadioGroup>(R.id.kids)
        radioGroup.setOnCheckedChangeListener { group, checkedId ->
            val selectedRadioButton = findViewById<RadioButton>(checkedId)

            // Do something with the selected radio button (e.g. display a message)
            Toast.makeText(this, "You selected ${selectedRadioButton.text}", Toast.LENGTH_SHORT).show()
        }
        val address = findViewById<EditText>(R.id.address)
        val phone = findViewById<EditText>(R.id.phone)

        //submit button
        val submit = findViewById<Button>(R.id.submitBtn)

        //save to firebase
        submit.setOnClickListener {
            val date = findViewById<EditText>(R.id.date).text.toString()
            val fromTime = findViewById<TextView>(R.id.fromTime).text.toString()
            val toTime = findViewById<TextView>(R.id.toTime).text.toString()
            val kids = findViewById<RadioButton>(radioGroup.checkedRadioButtonId).text.toString()
            val address = findViewById<EditText>(R.id.address).text.toString()
            val phone = findViewById<EditText>(R.id.phone).text.toString()

//            val db = Firebase.firestore
//            val data = hashMapOf(
//                "name" to name,
//                "date" to date,
//                "fromTime" to fromTime,
//                "toTime" to toTime,
//                "kids" to kids,
//                "address" to address,
//                "phone" to phone
//            )
//            db.collection("booking").add(data)
//                .addOnSuccessListener { documentReference ->
//                    Toast.makeText(this, "Booking successful", Toast.LENGTH_SHORT).show()
//                }
//                .addOnFailureListener { e ->
//                    Toast.makeText(this, "Booking failed", Toast.LENGTH_SHORT).show()
//                }
            database = FirebaseDatabase.getInstance().getReference("p12-db")
            val data = Data(date, fromTime, toTime, kids, address, phone)
            database.child(phone).child("1").setValue(data).addOnSuccessListener {
                Toast.makeText(this, "Registration successful", Toast.LENGTH_SHORT).show()
            }
                .addOnFailureListener { e ->
                    Toast.makeText(this, "Registration failed", Toast.LENGTH_SHORT).show()
                }
        }
    }
}