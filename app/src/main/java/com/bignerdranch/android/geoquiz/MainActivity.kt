package com.bignerdranch.android.geoquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    /* Below we use lateinit which means that it's not initialized until you use it */
    /* lateinit is used on property declarations to indicate to the compiler that you will provide
        a non-null View value before you try to use the contents of the property */
    private lateinit var trueButton: Button         // Pg 22 code
    private lateinit var falseButton: Button        // Pg 22 code

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /* The following code gets a reference to an inflated view by calling Activity.findViewById(Int) */
        trueButton = findViewById(R.id.true_button)         // Pg 22 code
        falseButton = findViewById(R.id.false_button)       // Pg 22 code

        /* Pg 23: Setting OnClickListeners to do something in response to the buttons being pressed */
        // Listing 1.5 (pg 23)
        trueButton.setOnClickListener { view: View ->
            /* Here we're calling the static function Toast.makeText(Context, Int, Int),
            * which creates and configures the Toast object*/
            // Listing 1.8 (pg 25)
            Toast.makeText(
                this,                       // context parameter is typically an instance of Activity, we're passing the instance of MainActivity as the Context argument (this)
                R.string.correct_toast,             // what the toast displays
                Toast.LENGTH_SHORT                  // specifies how long the message lasts (LENGTH_SHORT or LENGTH_LONG)
            ).show()                                // .show() makes the toast appear onscreen
        }
        // Listing 1.6 (pg 23)
        falseButton.setOnClickListener { view: View ->
            // Listing 1.8 (pg 25)
            Toast.makeText(
                this,
                R.string.incorrect_toast,           // what the toast displays
                Toast.LENGTH_SHORT                  // specifies how long the message lasts (LENGTH_SHORT or LENGTH_LONG)
            ).show()                                // .show() makes the toast appear onscreen
        }
    }
}