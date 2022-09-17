package com.example.wordle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isVisible

class MainActivity : AppCompatActivity() {
    private val wordToGuess = FourLetterWordList.getRandomFourLetterWord().uppercase()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var text1 = findViewById<TextView>(R.id.textView1)
        var text2 = findViewById<TextView>(R.id.textView2)
        var text3 = findViewById<TextView>(R.id.textView3)
        var text4 = findViewById<TextView>(R.id.textView4)
        var text5 = findViewById<TextView>(R.id.textView5)
        var text6 = findViewById<TextView>(R.id.textView6)

        var text7 = findViewById<TextView>(R.id.text7)
        var text8 = findViewById<TextView>(R.id.text8)
        var text9 = findViewById<TextView>(R.id.text9)
        var text10 = findViewById<TextView>(R.id.text10)
        var text11 = findViewById<TextView>(R.id.text11)
        var text12 = findViewById<TextView>(R.id.text12)

        var attempts = 0
        var guess = findViewById<EditText>(R.id.edittext)
        var changeAttempt = findViewById<Button>(R.id.Guess)
        changeAttempt.setOnClickListener {
            attempts++
            var str = guess.text.toString().uppercase()
            if (attempts == 1) {
                text1.isVisible = true
                text7.isVisible = true
                text2.isVisible = true
                text8.isVisible = true
                text7.text = str
                text8.text = checkGuess(str)
            }
            if (attempts == 2) {
                text3.isVisible = true
                text9.isVisible = true
                text4.isVisible = true
                text10.isVisible = true
                text9.text = str
                text10.text = checkGuess(str)
            }
            if (attempts == 3) {
                text5.isVisible = true
                text11.isVisible = true
                text6.isVisible = true
                text12.isVisible = true
                text11.text = str
                text12.text = checkGuess(str)
            }
            if (attempts > 3) {
                throw error("You exceed the maximum attempts!")
            }
        }
    }

    private fun checkGuess(guess: String) : String {
        var result = ""
        for (i in 0..3) {
            if (guess[i] == wordToGuess[i]) {
                result += "O"
            }
            else if (guess[i] in wordToGuess) {
                result += "+"
            }
            else {
                result += "X"
            }
        }
        return result
    }
}


