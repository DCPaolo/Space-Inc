package com.example.spaceinc.fragments.waitingRoom

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.spaceinc.R
import com.example.spaceinc.databinding.WaitingRoomFragmentBinding

class WaitingRoomFragment : Fragment() {


    private lateinit var binding: WaitingRoomFragmentBinding
    private lateinit var viewModel: WaitingRoomViewModel


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        // Inflate view and obtain an instance of the binding class
        binding = DataBindingUtil.inflate(inflater, R.layout.waiting_room_fragment, container, false)

        // Get the viewModel
        viewModel = ViewModelProviders.of(this).get(WaitingRoomViewModel::class.java)

        // Set the viewmodel for databinding
        binding.waitingGameViewModel = viewModel


        return binding.root
    }


}
