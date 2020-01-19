package com.example.spaceinc.fragments.login

import android.os.Handler
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.spaceinc.model.User
import com.example.spaceinc.model.UserPost
import com.example.spaceinc.network.UserRepository
import kotlinx.coroutines.Dispatchers

class LoginViewModel : ViewModel() {
    private val userRepository: UserRepository = UserRepository()

    private var labelUser: MutableList<String>? = null

    private val _validConnexion = MutableLiveData<Boolean>()
    val validConnexion: LiveData<Boolean>
        get() = _validConnexion


    init {
        _validConnexion.value = false
    }

    fun setLabel() {
        Log.i("test", "test")
    }

    fun onClickConnexion() {
        Log.i("test", "Click btn connexion ok")

        Handler().postDelayed({
            _validConnexion.value = false

        }, 1000)

        _validConnexion.value = true

    }



}
