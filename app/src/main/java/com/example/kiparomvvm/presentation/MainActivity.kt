package com.example.kiparomvvm.presentation

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.kiparomvvm.R
import com.example.kiparomvvm.common.TAG

class MainActivity : AppCompatActivity() {

    private lateinit var vm: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(TAG, "activity created")

        vm = ViewModelProvider(this, MainViewModelFactory(this))[MainViewModel::class.java]

        val dataTextView = findViewById<TextView>(R.id.dataTextView)
        val dataEditView = findViewById<EditText>(R.id.dataEditText)
        val sendButton = findViewById<Button>(R.id.sendButton)
        val receiveButton = findViewById<Button>(R.id.receiveButton)

        vm.resultLive.observe(this) {
            dataTextView.text = it
        }

        sendButton.setOnClickListener {
            vm.save(dataEditView.text.toString())
        }

        receiveButton.setOnClickListener {
            vm.load()
        }
    }
}