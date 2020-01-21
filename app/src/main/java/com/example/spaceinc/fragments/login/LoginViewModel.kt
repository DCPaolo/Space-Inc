package com.example.spaceinc.fragments.login

import android.os.Handler
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.spaceinc.model.User
import com.example.spaceinc.model.UserPost
import com.example.spaceinc.network.RetrofitClient
import com.example.spaceinc.network.WebService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginViewModel : ViewModel() {
    private val webService: WebService = RetrofitClient.webservice


    private var _labelUser: MutableLiveData<String>? = null
    var labelUser: LiveData<String>? = null
        get() = _labelUser

    private val _validConnexion = MutableLiveData<Boolean>()
    val validConnexion: LiveData<Boolean>
        get() = _validConnexion


    init {
        _validConnexion.value = false
        _labelUser?.value = ""
    }

    /** add new user in async task  */
    fun onClickConnexion(loginText : String) {

        if (loginText.isNotEmpty()) {
            val creationUser = webService.createUser(UserPost(loginText.toLowerCase()))

            creationUser?.enqueue(object : Callback<User?> {
                override fun onResponse(call: Call<User?>, response: Response<User?>) {
                    //redirectToScore()
                    _validConnexion.value = true

                    Handler().postDelayed({
                        _validConnexion.value = false
                    }, 1000)
                }

                override fun onFailure(call: Call<User?>, t: Throwable) {
                    Log.e("test", "Error : $t")
                }
            })
        }

    }




}
