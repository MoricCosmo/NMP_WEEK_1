 package com.example.myhelloworld

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myhelloworld.databinding.ActivityMainBinding
import com.example.myhelloworld.databinding.ActivityResultBinding

 class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

     var currQuestion = 0
     var score = 0

     fun displayQuestion() {
         binding.textQuestion.text = QuestionData.questions[currQuestion].question
     }

     fun nextQuestion() {
         currQuestion++
         if (currQuestion >= QuestionData.questions.size) {
             val intent = Intent(this, ResultActivity::class.java)
             intent.putExtra("score", score)
             startActivity(intent)
             finish()
         }
         displayQuestion()
     }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val playerName = intent.getStringExtra(IntroActivity.PLAYER_NAME)
        binding.txtWelcome.text = playerName

        displayQuestion()

        binding.btnTrue.setOnClickListener {
            if(QuestionData.questions[currQuestion].answer) {
                Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show()
                score += 10
            }
            else {
                Toast.makeText(this, "Incorrect", Toast.LENGTH_SHORT).show()
            }
            nextQuestion()
        }

        binding.btnFalse.setOnClickListener {
            if(!QuestionData.questions[currQuestion].answer) {
                Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show()
                score += 10
            }
            else {
                Toast.makeText(this, "Incorrect", Toast.LENGTH_SHORT).show()
            }
            nextQuestion()
        }
    }
}