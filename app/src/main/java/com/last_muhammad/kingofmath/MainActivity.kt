package com.last_muhammad.kingofmath

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.last_muhammad.kingofmath.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        random()
        binding.submitButton.setOnClickListener { submit() }
    }

    fun random() {
        val val1 = (0..100).random()
        val val2 = (0..100).random()
        var typeOperator = ""
        val operator = (0..3).random()
//        when(operator){
//            0 -> typeOperator = "+"
//            0 -> typeOperator = "-"
//            0 -> typeOperator = "X"
//            else -> typeOperator = "/"
//        }

        binding.questionText.text = "" + val1 + " + " + val2 + " = "
    }

    fun submit() {
        val str = binding.questionText.text.split(" ").toTypedArray()

        var result = 1
        when(str[1]){
            "+" -> result = str[0].toInt() + str[2].toInt()
            "-" -> result = str[0].toInt() - str[2].toInt()
            "X" -> result = str[0].toInt() * str[2].toInt()
            else -> result = str[0].toInt() / str[2].toInt()
        }
        result = str[0].toInt() + str[2].toInt()
        var result2 = ""
        result2 = result.toString()
        if (result2.equals(binding.answerInput.text)) {
            binding.debugText.text = "True"
        } else {
            binding.debugText.text = "The right answer " + result
        }
        val answer = binding.answerInput.text
        random()
    }
}