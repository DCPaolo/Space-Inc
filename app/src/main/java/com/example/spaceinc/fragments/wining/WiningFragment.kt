package com.example.spaceinc.fragments.wining

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.spaceinc.R

import kotlinx.android.synthetic.main.wining_fragment.*
import com.example.spaceinc.databinding.CreationRoomFragmentBinding
import com.example.spaceinc.databinding.WiningFragmentBinding


class WiningFragment : Fragment(){

    private lateinit var binding: WiningFragmentBinding
    private lateinit var viewModel: WiningViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        // Inflate view and obtain an instance of the binding class
        binding = DataBindingUtil.inflate(inflater, R.layout.wining_fragment, container, false)

        // Get the viewModel
        viewModel = ViewModelProviders.of(this).get(WiningViewModel::class.java)

        // Set the viewmodel for databinding
        binding.winingGameViewModel = viewModel

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
                    winingText.append("" + user.name + " -> " + user.score )
                }

            }
        })
    }






}
