package com.yash.bmicalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.core.view.isVisible

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        var weightEditText:EditText = findViewById(R.id.weight)
        var heightEditText:EditText = findViewById(R.id.height)
        var calculate:Button = findViewById(R.id.calculate)
        var resultTextView: TextView = findViewById(R.id.result)
        var image: ImageView = findViewById(R.id.image)
        var outputLayout:LinearLayout = findViewById(R.id.layoutOutput)


        calculate.setOnClickListener {
            var height:Double = (heightEditText.text.toString().trim()).toDouble()
            var weight:Double = (weightEditText.text.toString().trim()).toDouble()
            height = (height* 0.01)
            var BMI = (weight/(height*height))

            val toString = String.format("%.2f",BMI )
            outputLayout.isVisible = true
            when {
                BMI<18.5 -> {
                    resultTextView.text = toString+" Under Weight"
                    image.setImageResource(R.drawable.underweight)
                }
                BMI in 18.5..25.0 -> {
                    resultTextView.text = toString+" Good Health"
                    image.setImageResource(R.drawable.normal)
                }
                BMI in 25.0..30.0 -> {
                    resultTextView.text = toString+" Over Weight"
                    image.setImageResource(R.drawable.overweight)
                }
                BMI in 30.0..35.0 -> {
                    resultTextView.text = toString+" Obese"
                    image.setImageResource(R.drawable.obese)
                }
                BMI>35 -> {
                    resultTextView.text = toString+" Extremely Obese"
                    image.setImageResource(R.drawable.extremelyobese)
                }
            }
        }
    }
}