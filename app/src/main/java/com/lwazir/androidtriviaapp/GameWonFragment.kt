package com.lwazir.androidtriviaapp

import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.lwazir.androidtriviaapp.databinding.FragmentGameWonBinding


/**
 * A simple [Fragment] subclass.
 * Use the [GameWonFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class GameWonFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val binding: FragmentGameWonBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_game_won, container, false)
        binding.nextMatchButton.setOnClickListener { view: View ->
           // view.findNavController().navigate(GameFragmentDirections.actionGameFragmentToGameWonFragment(numQuestions,))
           view.findNavController().navigate(R.id.action_gameWonFragment_to_gameFragment)
        }//
        val args = GameWonFragmentArgs.fromBundle(arguments!!)
        Toast.makeText(context, "NumCorrect: ${args.numCorrect}, NumQuestions: ${args.numQuestions}", Toast.LENGTH_LONG).show()
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        //inflating winner menu
        inflater?.inflate(R.menu.winner_menu,menu)
        //check if the activity resolves
        if(null == getShareIntent().resolveActivity(activity!!.packageManager)){
            //hide the menu item if it doesn't resolve
            menu?.findItem(R.id.share)?.isVisible = false
        }

    }
    private fun getShareIntent() : Intent{
        val args = GameWonFragmentArgs.fromBundle(arguments!!)

        val shareIntent : Intent = Intent(Intent.ACTION_SEND)
        shareIntent.setType("text/plain")
            .putExtra(Intent.EXTRA_TEXT,getString(R.string.share_success_text, args.numCorrect,args.numQuestions))
            .putExtra(Intent.EXTRA_EMAIL,"wazirlalit96420@gmail.com")

        return shareIntent
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item!!.itemId)
        {
            R.id.share->shareSuccess()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun shareSuccess()
    {
            startActivity(getShareIntent())
    }
}
