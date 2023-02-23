package com.example.androind71.ui

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.example.androind71.Key
import com.example.androind71.databinding.ActivityEdit2Binding

class EditActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityEdit2Binding
    private lateinit var resultLauncher: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEdit2Binding.inflate(LayoutInflater.from(parent))
        backLauncher()
        backListeners()
        getData()
        setContentView(binding.root)
        
    }

    private fun backLauncher() {
        resultLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                if (result.resultCode == Activity.RESULT_OK) {
                    binding.textBackTv.setText(result.data?.getStringExtra(Key.KEY_FOR_DATA))
                }
            }
    }

    private fun getData() {
        binding.textBackTv.setText(intent.getStringExtra(Key.KEY_FOR_DATA))
    }


    private fun backListeners() {
        binding.backBtn.setOnClickListener {
            if (binding.textBackTv.text.isEmpty()) {
                Toast.makeText(this, "You should type something", Toast.LENGTH_SHORT).show()
            } else {
                backData()
            }
        }
    }

    private fun backData() {
        val intent = Intent()
        intent.putExtra(Key.KEY_FOR_DATA, binding.textBackTv.text.toString())
        resultLauncher.launch(intent)

    }


}