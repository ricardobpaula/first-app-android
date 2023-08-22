package com.ricardodev.firstapp

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doOnTextChanged
import androidx.lifecycle.Observer
import com.ricardodev.firstapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewBinding = ActivityMainBinding.inflate(layoutInflater)

        val view = viewBinding.root
        setContentView(view)

        val viewModel: MainViewModel by viewModels()

        viewModel.uiState.observe(this, handleState())

        viewBinding.name.doOnTextChanged { _, _, _, _ ->
            viewModel.onTextChanged()
        }

        viewBinding.submitButton.setOnClickListener {
            viewModel.updateName(viewBinding.name.text.toString())
        }

    }
    private fun handleState(): Observer<MainViewModel.UIState> = Observer<MainViewModel.UIState> { uiState ->
        viewBinding.viewName.text = uiState.currentName
        viewBinding.loading.visibility = if (uiState.isLoading) View.VISIBLE else View.GONE
    }

}