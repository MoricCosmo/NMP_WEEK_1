package com.example.myhelloworld

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myhelloworld.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var sharedFile = "com.moric.quiz"
        var shared: SharedPreferences = getSharedPreferences(sharedFile, Context.MODE_PRIVATE)

        var highScore = shared.getInt("H_SCORE", 0)

        val score = intent.getIntExtra("score", 0)

        if (score > highScore) {
            var edit = shared.edit().putInt("H_SCORE", score).apply()
        }

        binding.textHighScore.text = highScore.toString()
        binding.textResult.text = score.toString()
    }
}