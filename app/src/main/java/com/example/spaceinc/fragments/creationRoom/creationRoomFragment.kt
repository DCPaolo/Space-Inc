package com.example.spaceinc.fragments.creationRoom

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController

import com.example.spaceinc.R
import com.example.spaceinc.fragments.login.LoginFragmentDirections
import kotlinx.android.synthetic.main.creation_room_fragment.*

class creationRoomFragment : Fragment() {

    companion object {
        fun newInstance() = creationRoomFragment()
    }

    private lateinit var viewModel: CreationRoomViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.creation_room_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(CreationRoomViewModel::class.java)

        score_button.setOnClickListener {
            redirectToScore()
        }
    }

    private fun redirectToScore() {
        if (findNavController().currentDestination?.id == R.id.creationRoomFragment) {

            Toast.makeText(activity, "Go to scores", Toast.LENGTH_SHORT).show()
            val action = creationRoomFragmentDirections.actionCreationRoomFragmentToScoreFragment()

            NavHostFragment.findNavController(this).navigate(action)
        }
    }

}
