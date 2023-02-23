package com.example.androind71.ui

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.example.androind71.Key
import com.example.androind71.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var resultLauncher: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        initListeners()
        initLauncher()
        setData()
        setContentView(binding.root)


    }

    private fun setData() {
        binding.textEt.setText(intent.getStringExtra(Key.KEY_FOR_DATA))
    }

    private fun initLauncher() {
        resultLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                if (result.resultCode == Activity.RESULT_OK) {
                    binding.textEt.setText(result.data?.getStringExtra(Key.KEY_FOR_DATA))
                }
            }
    }

    private fun initListeners() {

        binding.intentBtn.setOnClickListener {

            if (binding.textEt.text.isNotEmpty()) {
                intentData()
            }else {
                Toast.makeText(this, "You should type something", Toast.LENGTH_SHORT).show()
            }

        }

    }

    private fun intentData() {
        val intent = Intent(this, EditActivity::class.java)
        intent.putExtra(Key.KEY_FOR_DATA, "value")
        resultLauncher.launch(intent)

    }

}