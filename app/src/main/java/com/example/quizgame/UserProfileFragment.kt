package com.example.quizgame

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.bumptech.glide.Glide
import com.example.quizgame.databinding.FragmentUserProfileBinding
import com.firebase.ui.auth.AuthUI
import com.google.firebase.auth.FirebaseAuth



class UserProfileFragment : Fragment() {
    lateinit var binding: FragmentUserProfileBinding
    val user = FirebaseAuth.getInstance().currentUser
    var highestScore:String="0"
    lateinit var sharedPreferences: SharedPreferences
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_user_profile,container,false)
        binding.btnLogout.setOnClickListener{
            AuthUI.getInstance().signOut(activity?.applicationContext!!)
                .addOnSuccessListener {
                    Navigation.findNavController(view!!).navigate(R.id.action_userProfileFragment_to_title2)
                }
        }
        binding.userprofile=this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        user.let { 
            Glide.with(this)
                .load(user?.photoUrl)
                .fitCenter()
                .placeholder(R.drawable.profilepic)
                .into(binding.userimage)
        }
        sharedPreferences = activity!!.getSharedPreferences("SP_HIGHEST_SCORE",
            Context.MODE_PRIVATE
            )
        highestScore = sharedPreferences.getInt("HIGHESTSCORE",0).toString()
    }


}