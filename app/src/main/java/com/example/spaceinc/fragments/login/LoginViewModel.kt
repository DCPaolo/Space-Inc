package com.example.spaceinc.fragments.login

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.spaceinc.network.UserRepository
import kotlinx.coroutines.Dispatchers

class LoginViewModel : ViewModel() {

    private val _validConnexion = MutableLiveData<Boolean>()
    val validConnexion: LiveData<Boolean>
        get() = _validConnexion


    init {
        _validConnexion.value = false
    }

    fun onClickConnexion() {
        Log.i("test", "Click btn connexion ok")
        _validConnexion.value = true
    }

}
