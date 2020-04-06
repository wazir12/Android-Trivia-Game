package com.lwazir.androidtriviaapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.lwazir.androidtriviaapp.databinding.FragmentGameOverBinding


/**
 * A simple [Fragment] subclass.
 * Use the [GameOverFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class GameOverFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentGameOverBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_game_over, container, false
        )
        binding.tryAgainButton.setOnClickListener { view: View ->
           view.findNavController().navigate(R.id.action_gameOverFragment2_to_gameFragment2)
        }
        return binding.root
    }

}
