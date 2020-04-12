package com.example.android.qwizzr

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private lateinit var mStartButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mStartButton = findViewById(R.id.btn_main_start)
        mStartButton.setOnClickListener { view ->
            val intent = Intent(this, QuestionActivity::class.java)
            startActivity(intent)
        }
    }
}
