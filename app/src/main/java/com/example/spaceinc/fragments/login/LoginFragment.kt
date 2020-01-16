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

class LoginFragment : Fragment() {


    private lateinit var viewModel: LoginViewModel
    private lateinit var binding: LoginFragmentBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //return inflater.inflate(R.layout.login_fragment, container, false)

        // Inflate view and obtain an instance of the binding class
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.login_fragment,
            container,
            false
        )

        // Log.i("LoginFragment", "Called ViewModelProviders.of")
        viewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)


        // Set the viewmodel for databinding - this allows the bound layout access
        // to all the data in the ViewModel
        binding.loginViewModel = viewModel
        binding.lifecycleOwner = this


        // Observer for the Game finished event
        viewModel.validConnexion.observe(this, Observer<Boolean> { hasFinished ->
            if (hasFinished) connexionOk()
        })

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)
        // TODO: Use the ViewModel
    }

    /**
     * Called when the game is finished
     */
    private fun connexionOk() {
        Toast.makeText(activity, "Go to scores", Toast.LENGTH_SHORT).show()
        val action = LoginFragmentDirections.actionLoginToScrore()
        NavHostFragment.findNavController(this).navigate(action)
    }
}


