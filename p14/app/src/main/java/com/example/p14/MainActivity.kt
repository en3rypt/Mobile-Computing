package com.example.p14

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        FirebaseApp.initializeApp(this)
        auth= FirebaseAuth.getInstance()

        val register = findViewById<View>(R.id.register)
        register.setOnClickListener {
            register(it)
        }
        val signin = findViewById<View>(R.id.signin)

        signin.setOnClickListener{
            login(it)
        }

    }

    override fun onStart() {
        super.onStart()
        val currentUser = auth.currentUser
        Toast.makeText(this, "User is already logged in"+FirebaseAuth.getInstance().currentUser?.uid, Toast.LENGTH_SHORT).show()
        if(currentUser!=null){
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }
    }
    fun register(view: View){
        val email = findViewById<EditText>(R.id.email).text.toString()
        val password= findViewById<EditText>(R.id.password).text.toString()
        if(email.isEmpty() || password.isEmpty()){
            return
        }
        auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener { task ->
            if(task.isSuccessful){
                val intent= Intent(this,MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }.addOnFailureListener { exception ->
            Toast.makeText(applicationContext,exception.localizedMessage,Toast.LENGTH_LONG).show()
        }
    }

    fun login(view: View){
        val email = findViewById<EditText>(R.id.email).text.toString()
        val password= findViewById<EditText>(R.id.password).text.toString()
        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Please enter email and password", Toast.LENGTH_SHORT).show()
            return
        }
        auth.signInWithEmailAndPassword(email,password).addOnCompleteListener { task ->
            if(task.isSuccessful){
                val intent= Intent(this,MainActivity2::class.java)
                startActivity(intent)
                finish()
            }
        }.addOnFailureListener { exception ->
            Toast.makeText(applicationContext,exception.localizedMessage, Toast.LENGTH_LONG).show()
        }
    }

}