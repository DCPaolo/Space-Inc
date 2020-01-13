package com.example.spaceinc.fragments.score

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

import com.example.spaceinc.R
import com.example.spaceinc.databinding.ScoreFragmentBinding
import kotlinx.android.synthetic.main.score_fragment.*

class ScoreFragment : Fragment() {

    private lateinit var binding: ScoreFragmentBinding

    private lateinit var viewModel: ScoreViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate view and obtain an instance of the binding class
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.score_fragment,
            container,
            false
        )
        Log.i("ScoreFragment", "Called ViewModelProviders.of")


        // Get the viewModel
        viewModel = ViewModelProviders.of(this).get(ScoreViewModel::class.java)

        // Set the viewmodel for databinding - this allows the bound layout access
        // to all the data in the ViewModel
        binding.gameViewModel = viewModel

        showUserByName()
        showBestUsers()

        return binding.root
    }


    /** Methods for updating the UI **/
    private fun showUserById() {
        viewModel.getUserId.observe(this, Observer {
            firstTextView.text = "User connected : " + it.name
        })
    }

    private fun showUserByName() {
        viewModel.getUserName.observe(this, Observer {
            firstTextView.text = "User connected : " + it.id
        })
    }

    private fun showAllUsers() {
        viewModel.getAllUsers.observe(this, Observer {
            for (user in it) {
                secondTextView.append("id : " + user.id + ", name : " + user.name + "\n")
            }
        })
    }

    private fun showBestUsers() {
        var position : Int = 0

        viewModel.getUsersScore.observe(this, Observer {
            for (user in it) {
                position++
                secondTextView.append(position.toString() + " : " + user.name + " | " + user.score + "\n")
            }
        })
    }

//    private fun updateWordText() {
//        binding.wordText.text = viewModel.word
//
//    }
//
//    private fun updateScoreText() {
//        binding.scoreText.text = viewModel.score.toString()
//    }

    /**
     * Called when the game is finished
     */
//    private fun gameFinished() {
//        Toast.makeText(activity, "Game has just finished", Toast.LENGTH_SHORT).show()
//        val action = ScoreFragmentDirections.actionGameToScore()
//        action.score = viewModel.score
//        NavHostFragment.findNavController(this).navigate(action)
//    }

}
