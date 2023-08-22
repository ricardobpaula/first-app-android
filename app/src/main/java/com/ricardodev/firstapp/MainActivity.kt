package com.ricardodev.firstapp

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
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

        val savedName = savedInstanceState?.getBundle(ResultActivity.ARG_NAME)

        viewBinding.submitButton.setOnClickListener{
            startActivity(resultIntent())
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(ResultActivity.ARG_NAME, viewBinding.name.text.toString())
    }

    private fun resultIntent(): Intent {
        var intent =  Intent(this, ResultActivity::class.java)
        intent.putExtra(ResultActivity.ARG_NAME, viewBinding.name.text.toString())
        return intent
    }
}