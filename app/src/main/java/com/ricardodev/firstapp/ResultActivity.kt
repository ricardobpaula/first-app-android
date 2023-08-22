package com.ricardodev.firstapp
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ricardodev.firstapp.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewBinding = ActivityResultBinding.inflate(layoutInflater)

        val view = viewBinding.root
        setContentView(view)

        val name = intent.extras?.getString(ARG_NAME, "Nenhum valor informado")

        viewBinding.textView.text = name
    }

    companion object {
        const val ARG_NAME = "ARG_NAME"
    }
}