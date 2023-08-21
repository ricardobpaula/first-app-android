package com.ricardodev.firstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private var number = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val titleTextView = findViewById<TextView>(R.id.textView)

        val textButton = findViewById<Button>(R.id.incrementButton)
        textButton.setOnClickListener {
            number ++
            titleTextView.setText("Contagem: $number")
        }

    }
}