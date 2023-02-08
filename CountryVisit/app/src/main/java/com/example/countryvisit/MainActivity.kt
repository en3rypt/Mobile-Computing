package com.example.countryvisit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import java.util.regex.Matcher;
import java.util.regex.Pattern

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val Fname = findViewById<TextView>(R.id.editTextTextPersonName)
        val Lname = findViewById<TextView>(R.id.editTextTextPersonName2)
        var countries = resources.getStringArray(R.array.country)
        val spinner = findViewById<Spinner>(R.id.spinner)
        val continueBtn = findViewById<Button>(R.id.button)
        val cancelBtn = findViewById<Button>(R.id.button2)
        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)


        val adapter = ArrayAdapter(this,android.R.layout.simple_spinner_item,countries)
        spinner.adapter = adapter

        continueBtn.setOnClickListener{
            val pattern = Regex("[^a-z]")
            val radioSelection =radioGroup.checkedRadioButtonId
            val countrySelected = spinner.selectedItem.toString()


            if (!pattern.containsMatchIn(Fname.text.toString().lowercase()) && !pattern.containsMatchIn(Lname.text.toString().lowercase()) && radioSelection!=-1 && countrySelected != "Select a Country"){
                val selectedRadioButton = findViewById<RadioButton>(radioSelection)
                val string: String = selectedRadioButton.text.toString()
                Toast.makeText(this,countrySelected,Toast.LENGTH_LONG).show()
                intent = Intent(this,MainActivity2::class.java)
                intent.putExtra("Value","First Name: "+Fname.text+"\nLast Name: "+Lname.text+"\nBusiness Type: "+string+"\nCountry: "+countrySelected)
                startActivity(intent)
            }else{
                if(!pattern.containsMatchIn(Fname.text.toString().lowercase()) || !pattern.containsMatchIn(Lname.text.toString().lowercase())){
                    Toast.makeText(this,"Name should not contain special characters or number",Toast.LENGTH_LONG)
                }
                if(radioSelection==-1){
                    Toast.makeText(this,"Select Business Visit Type",Toast.LENGTH_LONG).show()
                }

                if(countrySelected == "Select a Country"){
                    Toast.makeText(this,"Select Country",Toast.LENGTH_LONG).show()
                }
            }

        }
        cancelBtn.setOnClickListener {
            Fname.setText("")
            Lname.setText("")
            radioGroup.clearCheck()
            spinner.setSelection(0)
        }

    }
}