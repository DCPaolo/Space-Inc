package com.example.spaceinc.fragments.creationRoom

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.spaceinc.network.RetrofitClient
import com.example.spaceinc.network.WebService
import kotlinx.coroutines.Dispatchers


class CreationRoomViewModel : ViewModel() {
    var client: WebService = RetrofitClient.webservice

    val getAllRooms = liveData(Dispatchers.IO) {
        val allRooms = client.getRooms()
        emit(allRooms)
    }

}
