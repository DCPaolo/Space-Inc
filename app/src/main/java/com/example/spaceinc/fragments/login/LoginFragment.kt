package com.example.spaceinc.fragments.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.NavHostFragment
import com.example.spaceinc.R
import com.example.spaceinc.databinding.LoginFragmentBinding
import kotlinx.android.synthetic.main.login_fragment.*

class LoginFragment : Fragment() {

    private lateinit var viewModel: LoginViewModel
    private lateinit var binding: LoginFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        // Inflate view and obtain an instance of the binding class
        binding = DataBindingUtil.inflate(inflater, R.layout.login_fragment, container, false)

        // Get the viewModel
        viewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)

        // Set the viewmodel for databinding
        binding.loginViewModel = viewModel
        binding.lifecycleOwner = this


        // Observer
        viewModel.validConnexion.observe(this, Observer<Boolean> { isOk ->
            if (isOk) {
                redirectToScore()
                login.text.clear()
            }
        })

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        connexion_button.setOnClickListener {
            viewModel.onClickConnexion(login.text.toString())
        }
    }

    private fun redirectToScore() {
        Toast.makeText(activity, "Go to scores", Toast.LENGTH_SHORT).show()
        val action = LoginFragmentDirections.actionLoginToScrore()

        NavHostFragment.findNavController(this).navigate(action)
    }
}


