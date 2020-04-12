package com.example.android.qwizzr

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import android.widget.TextView
import com.example.android.qwizzr.model.Question
import kotlin.collections.ArrayList

class QuestionActivity : AppCompatActivity() {

    private lateinit var mQuestionTitle: TextView
    private lateinit var mQuestionText: TextView
    private lateinit var mOption1: RadioButton
    private lateinit var mOption2: RadioButton
    private lateinit var mOption3: RadioButton
    private lateinit var mOption4: RadioButton

    private var mQuestions: ArrayList<Question> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)

        mQuestionTitle = findViewById(R.id.tv_question_title)
        mQuestionText = findViewById(R.id.tv_question_text)
        mOption1 = findViewById(R.id.rb_option1)
        mOption2 = findViewById(R.id.rb_option2)
        mOption3 = findViewById(R.id.rb_option3)
        mOption4 = findViewById(R.id.rb_option4)

        getQuestions()

        mQuestionTitle.text = "Question 1"
        populateUI(mQuestions[0])
    }

    private fun populateUI(question: Question) {
        mQuestionText.text = question.questionText

        val answers: ArrayList<String> = ArrayList()
        answers.addAll(question.incorrectAnswers)
        answers.add(question.correctAnswer)
        answers.shuffle()

        mOption1.text = answers[0]
        mOption2.text = answers[1]
        mOption3.text = answers[2]
        mOption4.text = answers[3]
    }

    private fun getQuestions() {
        val questionText1 = "Which is not a type of neuron?"
        val correctAnswer1 = "Perceptual Neuron"
        val incorrectAnswers1 = arrayOf("Sensory Neuron", "Motor Neuron", "Interneuron")
        val question1 = Question(
            questionText1,
            correctAnswer1,
            incorrectAnswers1
        )

        val questionText2 =
            "How many times did Martina Navratilova win the Wimbledon Singles Championship?"
        val correctAnswer2 = "Nine"
        val incorrectAnswers2 = arrayOf("Ten", "Seven", "Eight")
        val question2 = Question(
            questionText2,
            correctAnswer2,
            incorrectAnswers2
        )

        val questionText3 =
            "What is the name of the former country that was succeeded by countries such as Serbia, Croatia and Slovenia?"
        val correctAnswer3 = "Yugoslavia"
        val incorrectAnswers3 = arrayOf("Czechoslovakia", "Abkhazia", "South Ossetia")
        val question3 = Question(
            questionText3,
            correctAnswer3,
            incorrectAnswers3
        )

        mQuestions.add(question1)
        mQuestions.add(question2)
        mQuestions.add(question3)
    }
}
