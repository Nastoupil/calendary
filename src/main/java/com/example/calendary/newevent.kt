package com.example.calendary

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import java.util.*

class Newevent : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_newevent)
        val editText = findViewById<EditText>(R.id.editText)
        val text = editText.text.toString()
// Perform actions with the text...

        val dateEditText = findViewById<EditText>(R.id.start)
        val dateEditText2 = findViewById<EditText>(R.id.end)

        dateEditText.setOnClickListener {
            val calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH)

            // Create a DatePickerDialog
            val datePickerDialog =
                DatePickerDialog(this, { _, selectedYear, selectedMonth, selectedDayOfMonth ->
                    // Set the selected date to the EditText
                    val selectedDate = "$selectedDayOfMonth/${selectedMonth + 1}/$selectedYear"
                    dateEditText.setText(selectedDate)
                }, year, month, dayOfMonth)
            datePickerDialog.show()
        }

        dateEditText2.setOnClickListener {
            val calendar2 = Calendar.getInstance()
            val year2 = calendar2.get(Calendar.YEAR)
            val month2 = calendar2.get(Calendar.MONTH)
            val dayOfMonth2 = calendar2.get(Calendar.DAY_OF_MONTH)

            // Create a DatePickerDialog
            val datePickerDialog =
                DatePickerDialog(this, { _, selectedYear, selectedMonth, selectedDayOfMonth ->
                    // Set the selected date to the EditText
                    val selectedDate = "$selectedDayOfMonth/${selectedMonth + 1}/$selectedYear"
                    dateEditText2.setText(selectedDate)
                }, year2, month2, dayOfMonth2)
            datePickerDialog.show()
        }

        val myButton = findViewById<Button>(R.id.button)
        myButton.setOnClickListener {
            val intent = Intent(this@Newevent, MainActivity::class.java)
            startActivity(intent)
        }

        val button2 = findViewById<Button>(R.id.button2)
        button2.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("event", text)
            intent.putE(dateEditText, dateEditText2)
            startActivity(intent)
        }
    }
}

private fun Intent.putE(dateEditText: EditText?, dateEditText2: EditText?) {
    val startDate = dateEditText?.text.toString()
    val endDate = dateEditText2?.text.toString()

    this.putExtra("text_startDate", startDate)
    this.putExtra("text_endDate", endDate)
}


