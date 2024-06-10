package za.ac.iie.practicum

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Weather : AppCompatActivity() {
    private val days = mutableListOf<String>()
    private val minTempsList = mutableListOf<Int>()
    private val maxTempsList = mutableListOf<Int>()
    private val weatherConditionsList = mutableListOf<String>()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather)

        val strDay = findViewById<EditText>(R.id.strDay)
        val minTemps = findViewById<EditText>(R.id.minTemps)
        val maxTemps = findViewById<EditText>(R.id.maxTemps)
        val weatherConditions = findViewById<EditText>(R.id.weatherConditions)
        val textView5 = findViewById<TextView>(R.id.textView5)

        val buttonSave = findViewById<Button>(R.id.Button3)
        val buttonExit = findViewById<Button>(R.id.button4)

        buttonSave.setOnClickListener {
            val day = strDay.text.toString()
            val minTemp = minTemps.text.toString().toIntOrNull() ?: 0
            val maxTemp = maxTemps.text.toString().toIntOrNull() ?: 0
            val weatherCondition = weatherConditions.text.toString()

            // Add data to lists
            days.add(day)
            minTempsList.add(minTemp)
            maxTempsList.add(maxTemp)
            weatherConditionsList.add(weatherCondition)

            // Create intent and pass data to DetailedViewActivity
            val intent = Intent(this, Detailed::class.java).apply {
                putStringArrayListExtra("days", ArrayList(days))
                putIntegerArrayListExtra("minTemps", ArrayList(minTempsList))
                putIntegerArrayListExtra("maxTemps", ArrayList(maxTempsList))
                putStringArrayListExtra("weatherConditions", ArrayList(weatherConditionsList))
            }
            startActivity(intent)

            // Clear input fields
            strDay.text.clear()
            minTemps.text.clear()
            maxTemps.text.clear()
            weatherConditions.text.clear()

            // Calculate and display average temperature
            calculateAverageTemperature(textView5)
        }

        buttonExit.setOnClickListener {
            finishAffinity() // This will close the app
        }
    }

    private fun calculateAverageTemperature(averageTempTextView: TextView) {
        if (minTempsList.isNotEmpty() && maxTempsList.isNotEmpty()) {
            val totalMinTemp = minTempsList.sum()
            val totalMaxTemp = maxTempsList.sum()
            val averageMinTemp = totalMinTemp / minTempsList.size
            val averageMaxTemp = totalMaxTemp / maxTempsList.size
            val averageTemp = (averageMinTemp + averageMaxTemp) / 2
            averageTempTextView.text = "Average Temperature: $averageTemp°C"
        }
    }
}