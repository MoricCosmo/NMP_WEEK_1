package com.example.myhelloworld

import android.R
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.RadioButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myhelloworld.databinding.ActivityNewQuestionBinding

class NewQuestionActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNewQuestionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewQuestionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.textLabelImageUrl.visibility = View.GONE
        binding.txtImageUrl.visibility = View.GONE

        binding.radioTemplate.setOnClickListener {
            with(binding) {
                textLabelChooseImage.visibility = View.VISIBLE
                spinnerImage.visibility = View.VISIBLE
                textLabelImageUrl.visibility = View.GONE
                txtImageUrl.visibility = View.GONE
            }
        }

        binding.radioUrl.setOnClickListener {
            with(binding) {
                textLabelChooseImage.visibility = View.GONE
                spinnerImage.visibility = View.GONE
                textLabelImageUrl.visibility = View.VISIBLE
                txtImageUrl.visibility = View.VISIBLE
            }
        }

        val items = arrayOf("karen", "mermaid", "mrkrab", "sponge", "squid")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, items)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerImage.adapter = adapter

        val imgid = this.resources.getIdentifier("karen", "drawable", this.packageName)
        binding.selectedImageQuestion.setImageResource(imgid)

        binding.spinnerImage.onItemSelectedListener = object: AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val imageid = applicationContext.resources.getIdentifier(items[position], "drawable", applicationContext.packageName)
                binding.selectedImageQuestion.setImageResource(imageid)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        binding.buttonSumbit.setOnClickListener {
            val radioAnswer = findViewById<RadioButton>(binding.radioGroupAnswer.checkedRadioButtonId)
            val selectedImage = items[binding.spinnerImage.selectedItemPosition]

            val imgid = this.resources.getIdentifier(selectedImage, "drawable", this.packageName)

            val newQuestion = Question(binding.textQuestion.text.toString(), radioAnswer.text.toString().lowercase().toBoolean(), imgid)

            val questionList = QuestionData.questions.toMutableList()
            questionList.add(newQuestion)
            QuestionData.questions = questionList.toTypedArray()

            Toast.makeText(this, "Question Added", Toast.LENGTH_SHORT).show()

            finish()
        }



    }
}