package com.example.spaceinc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        showOneUser()
        showAllUsers()
    }

    private fun showOneUser() {
        viewModel.getUserId.observe(this, Observer {
            firstTextView.text = "User connected : " + it.name
        })
    }

    private fun showAllUsers() {
        secondTextView.text = ""
        viewModel.getAllUsers.observe(this, Observer {
            for (user in it) {
                secondTextView.append("id : " + user.id + ", name : " + user.name + "\n")
            }
        })
    }
}

