package com.sally.anmp_week1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.sally.anmp_week1.databinding.FragmentGameBinding
import kotlin.random.Random

class GameFragment : Fragment() {
    private lateinit var binding: FragmentGameBinding
    private var angka1: Int = 0
    private var angka2: Int = 0
    private var score: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentGameBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if(arguments != null){
            val name = GameFragmentArgs.fromBundle(requireArguments()).playerName
            binding.txtPlayerName.setText("$name's turn")
        }

        generateRandomNumbers()

        binding.btnSubmit.setOnClickListener{
            var result = angka1 + angka2
            if(binding.txtAnswer.text.toString() == result.toString()){
                score++
                generateRandomNumbers()
            }
            else {
                val action = GameFragmentDirections.actionResultFragment(score)
                Navigation.findNavController(it).navigate(action)
            }
        }
    }

    private fun generateRandomNumbers() {
        angka1 = Random.nextInt(1, 101)
        angka2 = Random.nextInt(1, 101)
        binding.txtQuestion.text = angka1.toString() + " + " + angka2.toString()
    }
}