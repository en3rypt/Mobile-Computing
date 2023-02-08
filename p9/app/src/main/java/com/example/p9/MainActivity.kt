package com.example.p9

import android.content.Context
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.MediaController
import android.widget.VideoView

class MainActivity : AppCompatActivity() {
    private lateinit var menu: Menu
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    private fun playVideo(){
        val videoView = findViewById<VideoView>(R.id.videoView)
        val videoPath = "android.resource://" + packageName + "/" + R.raw.video2
        val uri = Uri.parse(videoPath)
        videoView.setVideoURI(uri)
        val mediaController = MediaController(this)
        videoView.setMediaController(mediaController)
        mediaController.setAnchorView(videoView)
        videoView.start()
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean{
        menuInflater.inflate(R.menu.menu, menu)
        this.menu = menu
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.hideBtn ->{
                val videoView = findViewById<VideoView>(R.id.videoView)
                val menuItem = menu.findItem(R.id.hideBtn)
                val playBtn = menu.findItem((R.id.playBtn))
                if(videoView.visibility == View.VISIBLE){
                    menuItem.title = "Show"
                    videoView.visibility = View.GONE
                    playBtn.isVisible = false
                }else{
                    videoView.visibility = View.VISIBLE
                    menuItem.title = "Hide"
                    playBtn.isVisible = true
                }
                true
            }
            R.id.playBtn ->{
                playVideo()
                true
            }
            R.id.ExitBtn ->{
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}