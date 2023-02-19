package com.bignerdranch.android.geoquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.bignerdranch.android.geoquiz.databinding.ActivityMainBinding // Pg40 Listing 2.7

class MainActivity : AppCompatActivity() {

    // Pg40 Listing 2.7: Initializing ActivityMainBinding
    private lateinit var binding: ActivityMainBinding

    // Pg 39 Listing 2.5: Adding a Question List
    private val questionBank = listOf(
        Question(R.string.question_australia, true),
        Question(R.string.question_oceans, true),
        Question(R.string.question_mideast, false),
        Question(R.string.question_africa, false),
        Question(R.string.question_americas, true),
        Question(R.string.question_asia, true))

    private var currentIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        // Pg 40 Listing 2.7: Initializing ActivityMainBinding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Removed true and false button declarations and instantiations

        // Pg 41 Listing 2.8: Using ActivityMainBinding, added binding to the front
        binding.trueButton.setOnClickListener { view: View ->
            /*Toast.makeText(
               this,
                R.string.correct_toast,
                Toast.LENGTH_SHORT
            ).show()*/
            // Pg 44 Listing 2.13: Calling checkAnswer(Boolean)
            checkAnswer(true)
        }
        // Pg 41 Listing 2.8: Using ActivityMainBinding, added binding to the front
        binding.falseButton.setOnClickListener { view: View ->
            /*Toast.makeText(
                this,
                R.string.incorrect_toast,
                Toast.LENGTH_SHORT
            ).show()*/
            // Pg 44 Listing 2.13: Calling checkAnswer(Boolean)
            checkAnswer(false)
        }

        //Pg 42 Listing 2.10: Wiring up the new button
        binding.nextButton.setOnClickListener{
            currentIndex = (currentIndex + 1) % questionBank.size
            //val questionTextResId = questionBank[currentIndex].textResId
            //binding.questionTextView.setText(questionTextResId)
            // Pg 43 Listing 2.11: Encapsulating with a Function; moved the above to a function
            updateQuestion()

        }
        // Pg 42 Listing 2.9: Wiring Up the TextView
        //val questionTextResId = questionBank[currentIndex].textResId
        //binding.questionTextView.setText(questionTextResId)
        // Pg 43 Listing 2.11: Encapsulating with a Function; moved the above to a function
        updateQuestion()
    }

    // Pg 43 Listing 2.11: Encapsulating with a Function
    private fun updateQuestion() {
        val questionTextResId = questionBank[currentIndex].textResId
        binding.questionTextView.setText(questionTextResId)
    }

    // Pg 44 Listing 2.12: Adding checkAnswer(Boolean)
    private fun checkAnswer(userAnswer: Boolean) {
        val correctAnswer = questionBank[currentIndex].answer

        val messageResId = if (userAnswer == correctAnswer) {
            R.string.correct_toast
        } else {
            R.string.incorrect_toast
        }

        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT).show()
    }
}