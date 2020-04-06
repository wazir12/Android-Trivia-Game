package com.lwazir.androidtriviaapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.lwazir.androidtriviaapp.databinding.FragmentTitleBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [TitleFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TitleFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding : FragmentTitleBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_title,container,false)
       //setting on click listener on play button to navigate to next fragment
        binding.playButton.setOnClickListener {
            view : View ->
            //getting instance of navigation controller
              Navigation.findNavController(view).navigate(R.id.action_titleFragment_to_gameFragment)
        }
        return binding.root
    }


}
