package com.example.spaceinc.fragments.score

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.spaceinc.R
import com.example.spaceinc.databinding.ScoreFragmentBinding
import kotlinx.android.synthetic.main.score_fragment.*

class ScoreFragment : Fragment() {

    private lateinit var binding: ScoreFragmentBinding
    private lateinit var viewModel: ScoreViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        // Inflate view and obtain an instance of the binding class
        binding = DataBindingUtil.inflate(inflater, R.layout.score_fragment, container, false)

        // Get the viewModel
        viewModel = ViewModelProviders.of(this).get(ScoreViewModel::class.java)

        // Set the viewmodel for databinding
        binding.scoreViewModel = viewModel

        showUserByName()
        showBestUsers()

        return binding.root
    }


    /** Display id of the user connected **/
    private fun showUserById() {
        viewModel.getUserId.observe(this, Observer {
            user_score.text = "User connected : " + it.id
        })
    }

    /** Display the name of the user connected **/
    private fun showUserByName() {
        viewModel.getUserName.observe(this, Observer {
            user_score.text = "User connected : " + it.name
        })
    }

    /** Display all users **/
    private fun showAllUsers() {
        viewModel.getAllUsers.observe(this, Observer {
            for (user in it) {
                secondTextView.append("id : " + user.id + ", name : " + user.name + "\n")
            }
        })
    }

    /** Display all user sort by score **/
    private fun showBestUsers() {
        var position : Int = 0

        viewModel.getUsersScore.observe(this, Observer {
            for (user in it) {
                position++
                secondTextView.append(position.toString() + " : " + user.name + " | " + user.score + "\n")
            }
        })
    }
}
