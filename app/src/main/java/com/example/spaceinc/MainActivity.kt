package com.example.spaceinc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.spaceinc.network.RetrofitClient
import com.example.spaceinc.network.WebService
import com.example.spaceinc.network.WebSockets

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

}

