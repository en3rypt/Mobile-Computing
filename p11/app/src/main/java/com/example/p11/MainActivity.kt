package com.example.p11

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val insertBtn = findViewById<Button>(R.id.insertBtn)
        val deleteBtn = findViewById<Button>(R.id.deleteBtn)
        val updateBtn = findViewById<Button>(R.id.updateBtn)
        val viewBtn = findViewById<Button>(R.id.viewBtn)
        val viewAll = findViewById<Button>(R.id.viewAllBtn)
        val rollno = findViewById<EditText>(R.id.rollno)
        val name = findViewById<EditText>(R.id.name)
        val marks = findViewById<EditText>(R.id.marks)


        insertBtn.setOnClickListener {
            val db = DBHelper(this, null)
            if(rollno.text.toString() != "" && name.text.toString() != "" && marks.text.toString() != ""){
                db.addName(rollno.text.toString(), name.text.toString(), marks.text.toString().toInt())
                Toast.makeText(this, "Data Inserted", Toast.LENGTH_SHORT).show()
                rollno.text.clear()
                name.text.clear()
                marks.text.clear()
            }else{
                Toast.makeText(this, "Please enter all the fields", Toast.LENGTH_SHORT).show()

            }
        }
        deleteBtn.setOnClickListener {
            val db = DBHelper(this, null)
            if(rollno.text.toString() != ""){
                db.deleteRollNo(rollno.text.toString())
                Toast.makeText(this, "Data Deleted", Toast.LENGTH_SHORT).show()
                rollno.text.clear()
                name.text.clear()
                marks.text.clear()
            }else{
                Toast.makeText(this, "Please enter roll no", Toast.LENGTH_SHORT).show()
            }
        }
        updateBtn.setOnClickListener {
            val db = DBHelper(this, null)
            if(rollno.text.toString() != "" && name.text.toString() != "" && marks.text.toString() != ""){
                db.updateName(rollno.text.toString(), name.text.toString(), marks.text.toString().toInt())
                Toast.makeText(this, "Data Updated", Toast.LENGTH_SHORT).show()
                rollno.text.clear()
                name.text.clear()
                marks.text.clear()
            }else{
                Toast.makeText(this, "Please enter all the fields", Toast.LENGTH_SHORT).show()
            }
        }
        viewBtn.setOnClickListener {
            val db = DBHelper(this, null)
            if(rollno.text.toString() != ""){
                val data = db.getRollNo(rollno.text.toString())

                if(data != null){
                    data.moveToFirst()

                    val builder = AlertDialog.Builder(this)
                    builder.setTitle("Result")
                    builder.setMessage("Roll No: " + data.getString(0) + "\nName: " + data.getString(1) + "\nMarks: " + data.getString(2) + "\n")
                    builder.setPositiveButton("Close"){dialogInterface, which ->
                    }
                    val alertDialog: AlertDialog = builder.create()
                    alertDialog.setCancelable(false)
                    alertDialog.show()

                }else{
                    Toast.makeText(this, "No data found", Toast.LENGTH_LONG).show()
                }
            }else{
                Toast.makeText(this, "Please enter roll no", Toast.LENGTH_SHORT).show()
            }
        }
        viewAll.setOnClickListener {
            val db = DBHelper(this, null)

            val data = db.getAll()

            if(data != null){
                data.moveToFirst()
                var dataString = ""
                val builder = AlertDialog.Builder(this)
                builder.setTitle("Result")
                do{
                    dataString += "Roll No: " + data.getString(0) + "\nName: " + data.getString(1) + "\nMarks: " + data.getString(2) + "\n\n"

                }while(data.moveToNext())
                builder.setMessage(dataString)
                builder.setPositiveButton("Close"){dialogInterface, which ->
                }
                val alertDialog: AlertDialog = builder.create()
                alertDialog.setCancelable(false)
                alertDialog.show()
            }else{
                Toast.makeText(this, "No data found", Toast.LENGTH_LONG).show()
            }
        }
    }
}