package com.example.spaceinc.fragments.fail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.NavHostFragment
import com.example.spaceinc.R
import com.example.spaceinc.databinding.FailFragmentBinding
import kotlinx.android.synthetic.main.fail_fragment.*

class FailFragment : Fragment() {
    private lateinit var binding: FailFragmentBinding
    private lateinit var viewModel: FailViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        // Inflate view and obtain an instance of the binding class
        binding = DataBindingUtil.inflate(inflater, R.layout.fail_fragment, container, false)

        // Get the viewModel
        viewModel = ViewModelProviders.of(this).get(FailViewModel::class.java)

        // Set the viewmodel for databinding
        binding.failGameViewModel = viewModel

        showBestUsers()

        return binding.root
    }




    /** Display all user sort by score **/
    private fun showBestUsers() {
        var position : Int = 0

        viewModel.getUsersScore.observe(this, Observer {
            for (user in it) {
                position++
                if(user.name=="toto"){
                    failText.append("" + user.name + " -> " + user.score )
                }

            }
        })
    }



    private fun redirectToWaitingRoom() {

        val action = FailFragmentDirections.actionFailFragmentToCreationRoomFragment()
        NavHostFragment.findNavController(this).navigate(action)

    }

}