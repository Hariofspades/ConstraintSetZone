package com.hariofspades.constraintsetzone

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imgActivity.setOnClickListener {
            startActivity(Intent(this, ImageActivity::class.java))
        }

        shopActivity.setOnClickListener {
            startActivity(Intent(this, ShoppingActivity::class.java))
        }

        carActivity.setOnClickListener {
            startActivity(Intent(this, CarouselActivity::class.java))
        }

        speakerActivity.setOnClickListener {
            startActivity(Intent(this, SpeakerActivity::class.java))
        }
    }
}
