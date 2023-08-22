package com.ricardodev.firstapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ricardodev.firstapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewBinding = ActivityMainBinding.inflate(layoutInflater)

        val view = viewBinding.root
        setContentView(view)

        viewBinding.submitButton.setOnClickListener{
            startActivity(resultIntent())
        }

    }

    private fun resultIntent(): Intent {
        var intent =  Intent(this, ResultActivity::class.java)
        intent.putExtra(ResultActivity.ARG_NAME, viewBinding.name.text.toString())
        return intent
    }
}