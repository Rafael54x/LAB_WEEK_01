package com.example.lab_week_01

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Find views
        val nameInput = findViewById<TextInputEditText>(R.id.name_input)
        val studentInput = findViewById<TextInputEditText>(R.id.student_input)
        val submitBtn = findViewById<Button>(R.id.name_submit)

        // Handle button click
        submitBtn.setOnClickListener {
            val name = nameInput.text.toString().trim()
            val studentNum = studentInput.text.toString().trim()

            when {
                name.isEmpty() -> {
                    nameInput.error = getString(R.string.name_empty)
                }
                studentNum.length != 11 -> {
                    studentInput.error = getString(R.string.student_empty)
                }
                else -> {
                    Toast.makeText(
                        this,
                        getString(R.string.name_greet) + name + "\nStudent Number: " + studentNum,
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        }
    }
}
