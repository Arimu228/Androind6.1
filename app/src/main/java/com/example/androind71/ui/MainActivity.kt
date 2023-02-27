package com.example.androind71.ui

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.example.androind71.databinding.ActivityMainBinding
import com.example.androind71.ui.EditActivity2.Companion.KEY_FOR_DATA

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var resultLauncher: ActivityResultLauncher<Intent>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initListeners()

    }

    private fun initListeners() {

        binding.intentBtn.setOnClickListener {
            if (binding.textEt.text.isNotEmpty()) {
                val intent = Intent(this, EditActivity2::class.java)
                intent.putExtra(KEY_FOR_DATA, binding.textEt.text.toString())
                resultLauncher.launch(intent)
            } else {
                Toast.makeText(this, "You should type something", Toast.LENGTH_SHORT).show()
            }

        }
        resultLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
                binding.textEt.setText(it.data?.getStringExtra(KEY_FOR_DATA))
            }
    }


    companion object {
        const val KEY_FOR_DATA = "data"
    }


}