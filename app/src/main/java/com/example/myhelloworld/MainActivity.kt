 package com.example.myhelloworld

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myhelloworld.databinding.ActivityMainBinding

 class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

     var currQuestion = 0;

     val questions = arrayOf(
         Question("Krusty Krab is the favorite burger in Bikini Bottom", false),
         Question("Spongebob lives in a pineapple under the sea", true),
         Question("Karen is Plankton’s wife", true),
         Question("Mermaid Man was once a superhero of Bikini Bottom", true),
         Question("Squidward has four hands", false)
     )

     fun displayQuestion() {
         binding.textQuestion.text = questions[currQuestion].question
     }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        displayQuestion()
    }
}