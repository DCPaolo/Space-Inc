package com.example.spaceinc.fragments.creationRoom

import android.app.AlertDialog
import android.content.DialogInterface
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.example.spaceinc.MainActivityViewModel
import com.example.spaceinc.R
import com.example.spaceinc.databinding.CreationRoomFragmentBinding
import com.example.spaceinc.databinding.WaitingRoomFragmentBinding
import com.example.spaceinc.network.WebSockets
import kotlinx.android.synthetic.main.create_room_popup.*
import kotlinx.android.synthetic.main.create_room_popup.view.*
import kotlinx.android.synthetic.main.creation_room_fragment.*

class creationRoomFragment : Fragment() {

    private lateinit var viewModel: MainActivityViewModel
    private lateinit var binding: CreationRoomFragmentBinding

    private val userId : Int = (0..200).random()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        // Inflate view and obtain an instance of the binding class
        binding = DataBindingUtil.inflate(inflater, R.layout.creation_room_fragment, container, false)

        // Get the viewModel
        viewModel = ViewModelProviders.of(activity!!).get(MainActivityViewModel::class.java)

        // Set the viewmodel for databinding
        binding.roomViewModel = viewModel

        viewModel.websocket.messageSocket.observe(this, Observer {
            Log.i("test",it.toString())
        })


        showAllRooms()

        return binding.root
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {

        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(activity!!).get(MainActivityViewModel::class.java)

        score_button.setOnClickListener {
            redirectToScore()
        }

        add_room_button.setOnClickListener {
            popUpCreationRoom()
        }
    }

    // To create a new room
    private fun popUpCreationRoom() {

        val layoutPopUp = LayoutInflater.from(context).inflate(R.layout.create_room_popup, null)

        // Creation popUp
        val popUpAddRoom = AlertDialog.Builder(context)

        popUpAddRoom.setPositiveButton("Créer", object : DialogInterface.OnClickListener{
            override fun onClick(dialog: DialogInterface?, which: Int) {
                val editText = layoutPopUp.findViewById<EditText>(R.id.new_room_name)
                val roomName = editText?.text.toString()

                //request websocket to join this room with id user
                viewModel.websocket.joinRoom(roomName,  userId)
                redirectToWaitingRoom()
                dialog?.dismiss()
            }

        })

        popUpAddRoom.setTitle("Nom de la salle")
        popUpAddRoom.setView(layoutPopUp)
        popUpAddRoom.show()
    }

    /** Display all rooms **/
    private fun showAllRooms() {

        viewModel.getAllRooms.observe(this, Observer {

            if (it.all?.isEmpty()!!) {
                val noRoom = TextView(context)
                noRoom.text = getString(R.string.no_room_active)
                allRooms.addView(noRoom)
            }

            it.all?.forEach {room ->
                var newRoom = Button(context)
                newRoom.text = room.name
                newRoom.tag = "join_room"
                newRoom.setBackgroundResource(R.drawable.button_marge)

                newRoom.setOnClickListener {
                    Toast.makeText(context,room.name.toString(),Toast.LENGTH_SHORT).show()
                    viewModel.websocket.joinRoom(newRoom.text.toString(), userId)
                    redirectToWaitingRoom()
                }

                allRooms.addView(newRoom)
            }
        })

    }

    private fun redirectToScore() {
        if (findNavController().currentDestination?.id == R.id.creationRoomFragment) {
            val action = creationRoomFragmentDirections.actionCreationRoomFragmentToScoreFragment()
            NavHostFragment.findNavController(this).navigate(action)
        }
    }

    private fun redirectToWaitingRoom() {
//        if (findNavController().currentDestination?.id == R.id.waitingRoomFragment) {

            val action = creationRoomFragmentDirections.actionCreationRoomFragmentToWaitingRoomFragment()
            NavHostFragment.findNavController(this).navigate(action)
//        }
    }


}
