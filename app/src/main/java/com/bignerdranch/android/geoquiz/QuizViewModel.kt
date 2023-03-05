package com.bignerdranch.android.geoquiz
import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

// 4.2 Adding a ViewModel

private const val TAG = "QuizViewModel"

// 4.8 Storing data in the SavedStateHandle
const val CURRENT_INDEX_KEY = "CURRENT_INDEX_KEY"

class QuizViewModel(private val savedStateHandle: SavedStateHandle) : ViewModel(){

// Removed as they're no longer needed to view in Logcat
/*    init {Log.d(TAG, "ViewModel instance created")}
    //onCleared() is called before a ViewModel is destroyed
    override fun onCleared() {super.onCleared()
        Log.d(TAG, "ViewModel instance about to be destroyed")
    }*/


    // 4.5: Pasting model data into QuizViewModel
    // moved both questionBank and currentIndex from MainActivity.kt
    private val questionBank = listOf(
        Question(R.string.question_australia, true),
        Question(R.string.question_oceans, true),
        Question(R.string.question_mideast, false),
        Question(R.string.question_africa, false),
        Question(R.string.question_americas, true),
        Question(R.string.question_asia, true))

    private var currentIndex: Int   // 4.8: Removed =0 and added : Int
    // 4.8: Storing data in the SavedStateHandle
    get() = savedStateHandle.get(CURRENT_INDEX_KEY) ?: 0            // ?: 0 If there is no savedStateHandle, set it to 0
    set(value) = savedStateHandle.set(CURRENT_INDEX_KEY, value)


    // 4.6: Adding business logic to QuizViewModel

    // Property that returns a question's answer
    val currentQuestionAnswer: Boolean
        get() = questionBank[currentIndex].answer

    // Property that returns a question's text
    val currentQuestionText: Int
        get() = questionBank[currentIndex].textResId

    // Function that lets you advance to the next question
    fun moveToNext() {
        currentIndex = (currentIndex + 1) % questionBank.size
    }

}