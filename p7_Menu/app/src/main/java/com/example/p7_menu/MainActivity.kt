package com.example.p7_menu

import android.R.color
import android.graphics.Color
import android.os.Bundle
import android.util.TypedValue
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.PopupMenu
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import java.util.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val clickme = findViewById<Button>(R.id.clickme)
        clickme.setOnClickListener {
            val popup = PopupMenu(this,it)
            val rnd = Random()
            popup.inflate(R.menu.btn_menu)
            popup.setOnMenuItemClickListener { item ->
                when (item.itemId) {
                    R.id.small -> {
                        clickme.setTextSize(TypedValue.COMPLEX_UNIT_SP, 10f)
                        true
                    }
                    R.id.medium -> {
                        clickme.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20f)
                        true
                    }
                    R.id.large -> {
                        clickme.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30f)
                        true
                    }
                    R.id.changeColor ->{
                        clickme.setTextColor(
                            Color.argb(
                                255,
                                rnd.nextInt(256),
                                rnd.nextInt(256),
                                rnd.nextInt(256)
                            )
                        )
                        true
                    }
                    else -> false

                }
            }
            popup.show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu, menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val relativeLayout = findViewById<ConstraintLayout>(R.id.rlVar1);
        return when (item.itemId) {
            R.id.red -> {

                relativeLayout.setBackgroundColor(getColor(R.color.red))

                true
            }
            R.id.green->{
                relativeLayout.setBackgroundColor(getColor(R.color.green))

                true
            }

            R.id.yellow->{
                relativeLayout.setBackgroundColor(getColor(R.color.yellow))
                true
            }
            R.id.blue->{
                relativeLayout.setBackgroundColor(getColor(R.color.blue))
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }
}