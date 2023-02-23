package com.example.androind71.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.LayoutInflater
import android.widget.Toast
import com.example.androind71.Key
import com.example.androind71.databinding.ActivityEdit2Binding

class EditActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityEdit2Binding
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEdit2Binding.inflate(LayoutInflater.from(parent))
        backListeners()
        setContentView(binding.root)

    }

    private fun backListeners() {
        binding.backBtn.setOnClickListener {
            if (binding.textBackTv.text.isNotEmpty()) {
                val text = binding.textBackTv.text.toString()
                setResult(RESULT_OK, Intent().putExtra(Key.KEY_FOR_DATA, text))
                finish()
            } else {
                Toast.makeText(this, "You should type something", Toast.LENGTH_SHORT).show()
            }
        }
    }


}