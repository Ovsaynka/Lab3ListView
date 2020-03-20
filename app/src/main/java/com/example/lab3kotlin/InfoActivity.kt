package com.example.lab3kotlin

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.user_page.*

class InfoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.user_page)

        //Show data from "MainActivity"
        val name: String? = intent.getStringExtra("name")
        val details: String? = intent.getStringExtra("details")
        val image: Int = intent.getIntExtra("image", 0)

        //add data to View
        userNameTextView.text = name
        userDetailsTextView.text = details
        userPhotoImageView.setImageResource(image)
        //beck to user list Button
        backButton.setOnClickListener {
            startActivity(Intent(this@InfoActivity, MainActivity::class.java))
        }
    }
}