package com.example.spaceinc.fragments.waitingRoom

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.spaceinc.R
import com.example.spaceinc.databinding.WaitingRoomFragmentBinding
import com.example.spaceinc.network.WebSockets
import kotlinx.android.synthetic.main.waiting_room_fragment.*

class WaitingRoomFragment : Fragment() {


    private lateinit var binding: WaitingRoomFragmentBinding
    private lateinit var viewModel: WaitingRoomViewModel
    var websocket = WebSockets()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        // Inflate view and obtain an instance of the binding class
        binding = DataBindingUtil.inflate(inflater, R.layout.waiting_room_fragment, container, false)

        // Get the viewModel
        viewModel = ViewModelProviders.of(this).get(WaitingRoomViewModel::class.java)

        // Set the viewmodel for databinding
        binding.waitingGameViewModel = viewModel


        websocket.messageSocket.observe(this, Observer {
            Log.i("test",it.toString())
        })

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        buttonReady.setOnClickListener{
//            websocket.startGame()
//        }
    }

}
