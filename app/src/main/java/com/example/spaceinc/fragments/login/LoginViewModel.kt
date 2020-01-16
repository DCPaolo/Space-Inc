package com.example.spaceinc.fragments.login

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.spaceinc.model.User
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


        // If field not empty
//        if(labelUser?.isEmpty()!!) {
//            return Log.i("test", "Nom vide")
//        }
        // If name not in list user name, create user with name

        // Connexion with id user

            // Allow navigation to another fragment

        _validConnexion.value = true
    }


    fun connectUser(name: String) {
        userRepository.createUser(name)
    }
}
