package com.example.templatekotlin001

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView
import androidx.annotation.RequiresApi

class MainActivity : AppCompatActivity() {
    private var input = StringBuilder()
    private lateinit var display: TextView
    private lateinit var historyViews: List<TextView>
    private val calculationHistory = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        display = findViewById(R.id.textView)

        historyViews = listOf(
            findViewById(R.id.textView2),
            findViewById(R.id.textView3),
            findViewById(R.id.textView4),
            findViewById(R.id.textView7),
            findViewById(R.id.textView6),
            findViewById(R.id.textView7),
            findViewById(R.id.textView8),
            findViewById(R.id.textView9),
            findViewById(R.id.textView10),
        )

        val buttons = mapOf(
            "0" to findViewById<Button>(R.id.button0),
            "1" to findViewById<Button>(R.id.button1),
            "2" to findViewById<Button>(R.id.button2),
            "3" to findViewById<Button>(R.id.button3),
            "4" to findViewById<Button>(R.id.button4),
            "5" to findViewById<Button>(R.id.button5),
            "6" to findViewById<Button>(R.id.button6),
            "7" to findViewById<Button>(R.id.button7),
            "8" to findViewById<Button>(R.id.button8),
            "9" to findViewById<Button>(R.id.button9),

            "*" to findViewById<Button>(R.id.buttonMultiplication),
            "-" to findViewById<Button>(R.id.buttonSoustraction),
            "+" to findViewById<Button>(R.id.buttonAddition),
            "=" to findViewById<Button>(R.id.buttonResultat),
            "/" to findViewById<Button>(R.id.buttonDivision),
            "Supp" to findViewById<Button>(R.id.buttonEffacer),
            "%" to findViewById<Button>(R.id.buttonDivisionE),
            "C" to findViewById<Button>(R.id.buttonClean),
        )
        buttons.forEach { (key, button) ->
            button.setOnClickListener { actionButton(key) }
        }
    }
    private fun actionButton(inputValue: String) {
        when (inputValue) {
            "=" -> {
                try {
                    val result = eval(input.toString())
                    val resultText = "${input.toString()} = $result"
                    display.text = result.toString()
                    input.clear()
                    input.append(result)

                    addToHistory(resultText)
                } catch (e: Exception) {
                    display.text = "Erreur"
                    input.clear()
                }
            }
            "Supp" -> {
                if (input.isNotEmpty()) {
                    input.deleteCharAt(input.length - 1)
                }
                display.text = if (input.isEmpty()) "0" else input.toString()
            }
            "C" -> {
                input.clear()
                display.text = "0"
            }
            else -> {
                if (display.text == "0" || display.text == "Erreur") {
                    display.text = ""
                }
                input.append(inputValue)
                display.text = input.toString()
            }
        }
    }

    private fun eval(expression: String): Double {
        val symbols = expression.split("(?<=[-+*/%])|(?=[-+*/%])".toRegex()).map { it.trim() }
        val result = mutableListOf<Double>()
        var operator = '+';

        for (sympol in symbols) {
            if (sympol.isEmpty()) continue;
            if (sympol in listOf("+", "-", "*", "/", "%")) {
                operator = sympol[0];
            } else {
                val num = sympol.toDouble()
                when (operator) {
                    '+' -> result.add(num);
                    '-' -> result.add(-num);
                    '*' -> result[result.lastIndex] = result.last() * num;
                    '/' -> result[result.lastIndex] = result.last() / num;
                    '%' -> result[result.lastIndex] = result.last() % num;
                }
            }
        }
        return result.sum()
    }
    private fun addToHistory(entry: String) {
        calculationHistory.add(0, entry)
        if (calculationHistory.size > historyViews.size) {
            calculationHistory.removeAt(calculationHistory.size - 1)
        }

        historyViews.forEachIndexed { index, textView ->
            textView.text = calculationHistory.getOrNull(index) ?: ""
        }
    }
}