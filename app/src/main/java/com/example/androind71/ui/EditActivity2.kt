package com.example.androind71.ui

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.example.androind71.R
import com.example.androind71.databinding.ActivityEdit2Binding

class EditActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityEdit2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEdit2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        backListeners()

    }

    private fun backListeners() {
        binding.textBackTv.setText(intent.getStringExtra(KEY_FOR_DATA))
        binding.backBtn.setOnClickListener {
            if (binding.textBackTv.text.isNotEmpty()) {
                val text = binding.textBackTv.text.toString()
                setResult(RESULT_OK, Intent().putExtra(KEY_FOR_DATA, text))
                finish()
            } else {
                Toast.makeText(this, getString(R.string.toastForActivity), Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }

    companion object {
        const val KEY_FOR_DATA = "data"
    }


}