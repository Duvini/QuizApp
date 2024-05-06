package com.example.quizgame

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.example.quizgame.databinding.FragmentCorrectAnswerBinding
import com.example.quizgame.databinding.FragmentQuizGameBinding

class QuizWon : Fragment() {
    lateinit var binding: FragmentCorrectAnswerBinding
    var earnedScore:String = ""
    var wrongAnswerText:String = ""
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
      binding=DataBindingUtil.inflate(inflater,R.layout.fragment_correct_answer,container,false)
       binding.btnPlayNext.setOnClickListener{
           Navigation.findNavController(it).navigate(R.id.action_quizWon_to_title2)
       }
        binding.quizwon=this
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            val args = QuizWonArgs.fromBundle(it)
            earnedScore = args.score.toString()
            if(args.wrongAnswers.isNotEmpty()){
                binding.yourwronganswer.visibility = View.VISIBLE
                binding.txtWrongAnswer.visibility = View.VISIBLE

                for( ans in args.wrongAnswers){
                    wrongAnswerText = wrongAnswerText+ans+"\n"
                }
            }
        }
    }


}