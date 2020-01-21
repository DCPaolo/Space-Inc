package com.example.spaceinc

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.spaceinc.network.RetrofitClient
import com.example.spaceinc.network.WebService
import com.example.spaceinc.network.WebSockets
import kotlinx.coroutines.Dispatchers

class MainActivityViewModel : ViewModel() {

    val websocket = WebSockets()

    var client: WebService = RetrofitClient.webservice

    val getAllRooms = liveData(Dispatchers.IO) {
        val allRooms = client.getRooms()
        emit(allRooms)
    }


}