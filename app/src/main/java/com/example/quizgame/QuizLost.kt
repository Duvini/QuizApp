package com.example.quizgame

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.example.quizgame.databinding.FragmentWrongAnswerBinding

class QuizLost : Fragment() {
    lateinit var binding: FragmentWrongAnswerBinding
    var earnedScore="0"
    var wrongAnswerText =""
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= DataBindingUtil.inflate(inflater,R.layout.fragment_wrong_answer,container,false)
        binding.btnTryAgain.setOnClickListener{
            Navigation.findNavController(it).navigate(R.id.action_quizLost_to_title2)
        }
        binding.quizlost=this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            val args = QuizLostArgs.fromBundle(it)
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