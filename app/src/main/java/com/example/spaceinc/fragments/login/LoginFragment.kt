package com.example.spaceinc.fragments.login

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.example.spaceinc.R
import com.example.spaceinc.databinding.LoginFragmentBinding
import com.example.spaceinc.model.User
import com.example.spaceinc.model.UserPost
import com.example.spaceinc.network.RetrofitClient
import com.example.spaceinc.network.WebService
import kotlinx.android.synthetic.main.login_fragment.*
import retrofit2.*

class LoginFragment : Fragment() {


    private lateinit var viewModel: LoginViewModel
    private lateinit var binding: LoginFragmentBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate view and obtain an instance of the binding class
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.login_fragment,
            container,
            false
        )

        viewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)


        // Set the viewmodel for databinding - this allows the bound layout access
        // to all the data in the ViewModel
        binding.loginViewModel = viewModel
        binding.lifecycleOwner = this


        // Observer
        viewModel.validConnexion.observe(this, Observer<Boolean> { isOk ->
            if (isOk) addUser()
        })

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)
    }

    var webService: WebService = RetrofitClient.webservice

    /**
     * add new user in async task
     */
    fun addUser(){
        var loginText = login.text.toString()

        if (!loginText.isEmpty()) {
            val creationUser = webService.createUser(UserPost(loginText.toLowerCase()))

            creationUser?.enqueue(object : Callback<User?> {
                override fun onResponse(call: Call<User?>, response: Response<User?>) {
                    val newUser = response.body()
                    newUser?.let {
                        Log.d("Api", "Player Registered :  ${it.name}")
                    }
                    redirectToScore()
                }

                override fun onFailure(call: Call<User?>, t: Throwable) {
                    Log.e("Api", "Error : $t")
                }
            })
            login.text.clear()
        }
    }

    fun redirectToScore() {
        Toast.makeText(activity, "Go to scores", Toast.LENGTH_SHORT).show()
        val action = LoginFragmentDirections.actionLoginToScrore()

        NavHostFragment.findNavController(this).navigate(action)
    }

}


