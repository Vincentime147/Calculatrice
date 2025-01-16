package com.example.templatekotlin001

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import com.example.templatekotlin001.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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

        )
    }

        //display = findViewById(R.id.textView3)


}