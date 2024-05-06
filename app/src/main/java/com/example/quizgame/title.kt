package com.example.quizgame

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.quizgame.databinding.FragmentTitleBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth


class title : Fragment() {
    lateinit var binding: FragmentTitleBinding
    val user = FirebaseAuth.getInstance().currentUser
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_title,container,false)
        binding.btnPlay.setOnClickListener{
            Navigation.findNavController(it).navigate(R.id.action_title2_to_quizGameFragment)
        }
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.app_menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(NavigationUI.onNavDestinationSelected(item,view!!.findNavController())){
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(user==null){
            Navigation.findNavController(view!!).navigate(R.id.action_title2_to_loginFragment)
        }
    }

}