package com.example.spaceinc.fragments.creationRoom

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
import com.example.spaceinc.databinding.CreationRoomFragmentBinding
import com.example.spaceinc.model.Room
import com.example.spaceinc.model.RoomList
import kotlinx.android.synthetic.main.creation_room_fragment.*

class creationRoomFragment : Fragment() {

    private lateinit var viewModel: CreationRoomViewModel
    private lateinit var binding: CreationRoomFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        // Inflate view and obtain an instance of the binding class
        binding = DataBindingUtil.inflate(inflater, R.layout.creation_room_fragment, container, false)

        // Get the viewModel
        viewModel = ViewModelProviders.of(this).get(CreationRoomViewModel::class.java)

        // Set the viewmodel for databinding
        binding.roomViewModel = viewModel

        showAllRooms()

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(CreationRoomViewModel::class.java)

        score_button.setOnClickListener {
            redirectToScore()
        }
    }

    /** Display all rooms **/
    private fun showAllRooms() {
        viewModel.getAllRooms.observe(this, Observer {

            for (room in it) {




            }


            val listRoom: List<Room> = it
            for(item in listRoom){
                allRooms.append("room : $item \n")
                Log.i("test", item.toString())
            }
        })
    }

    private fun redirectToScore() {
        if (findNavController().currentDestination?.id == R.id.creationRoomFragment) {

            Toast.makeText(activity, "Go to scores", Toast.LENGTH_SHORT).show()
            val action = creationRoomFragmentDirections.actionCreationRoomFragmentToScoreFragment()
            NavHostFragment.findNavController(this).navigate(action)
        }
    }


}
