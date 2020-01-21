package com.example.spaceinc.fragments.waitingRoom

import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.NavHostFragment
import com.example.spaceinc.MainActivityViewModel
import com.example.spaceinc.R
import com.example.spaceinc.databinding.WaitingRoomFragmentBinding
import com.example.spaceinc.fragments.login.LoginFragmentDirections
import com.example.spaceinc.network.WebSockets
import kotlinx.android.synthetic.main.waiting_room_fragment.*

class WaitingRoomFragment : Fragment() {


    private lateinit var binding: WaitingRoomFragmentBinding
    private lateinit var viewModel: MainActivityViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        // Inflate view and obtain an instance of the binding class
        binding = DataBindingUtil.inflate(inflater, R.layout.waiting_room_fragment, container, false)

        // Get the viewModel
        viewModel = ViewModelProviders.of(activity!!).get(MainActivityViewModel::class.java)

        // Set the viewmodel for databinding
        binding.waitingGameViewModel = viewModel


        viewModel.websocket.messageSocket.observe(this, Observer {
            Log.i("test",it.toString())

            logGame.append(it.toString() + "\n \n")

        })

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        buttonReady.setOnClickListener{
            viewModel.websocket.startGame()
        }


        redirectToFail()
    }

    private fun redirectToFail() {
        val handle = Handler()
        handle.postDelayed({
            val action = WaitingRoomFragmentDirections.actionWaitingRoomFragmentToFailFragment()

            NavHostFragment.findNavController(this).navigate(action)
        }, 30000)
    }

}
