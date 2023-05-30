package com.example.calendary

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CalendarView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var dateTV: TextView
    lateinit var calendarView: CalendarView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        dateTV = findViewById(R.id.idTVDate)
        calendarView = findViewById(R.id.calendarView)
        calendarView.firstDayOfWeek = Calendar.MONDAY
        val sdf = SimpleDateFormat("EEEE d. MMMM yyyy", Locale("cs", "CZ"))
        calendarView.setOnDateChangeListener { view, year, month, dayOfMonth ->
            val calendar = Calendar.getInstance().apply {
                set(year, month, dayOfMonth)
            }
            val formattedDate = sdf.format(calendar.time)
            dateTV.text = formattedDate
        }
        val myButton = findViewById<Button>(R.id.button)
        myButton.setOnClickListener {
            val intent = Intent(this@MainActivity, Newevent::class.java)
            startActivity(intent)
        }

        // Retrieve the start and end dates from the intent extras
        val startDate = intent.getStringExtra("text_startDate")
        val endDate = intent.getStringExtra("text_endDate")

        // Find the TextView fields in the MainActivity layout
        val startDateTextView = findViewById<TextView>(R.id.eventRecyclerView)
        val endDateTextView = findViewById<TextView>(R.id.eventRecyclerView)

        // Set the start and end dates to the TextView fields
        startDateTextView.text = "Start Date: $startDate"
        endDateTextView.text = "End Date: $endDate"


    }
}



