package com.interndesire.dateandtime

import android.icu.text.SimpleDateFormat
import android.icu.util.Calendar
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import java.util.Locale

class MainActivity : AppCompatActivity() {

    private lateinit var dateTimeTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dateTimeTextView = findViewById(R.id.curDateTime);

        updateDateTime()

        // You can also update the date and time periodically if needed, e.g., every second.
        // You may use a Handler and Runnable for this purpose.

        val handler = android.os.Handler()
        val runnable = object : Runnable {
            override fun run() {
                updateDateTime()
                handler.postDelayed(this, 1000) // Update every 1000 milliseconds (1 second)
            }
        }
        handler.postDelayed(runnable, 1000) // Start the initial update after 1000 milliseconds
    }

    private fun updateDateTime() {
        val currentDateTime = Calendar.getInstance().time
        val dateFormat = SimpleDateFormat("EEEE, MMMM dd, yyyy", Locale.getDefault())
        val timeFormat = SimpleDateFormat("hh:mm:ss a", Locale.getDefault())

        val formattedDate = dateFormat.format(currentDateTime)
        val formattedTime = timeFormat.format(currentDateTime)

        val dateTimeString = "$formattedDate\n\n$formattedTime"
        dateTimeTextView.text = dateTimeString
    }

}