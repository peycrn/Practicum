package za.ac.iie.practicum

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class Detailed : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed)

        val day = findViewById<TextView>(R.id.day)
        val minTemp = findViewById<TextView>(R.id.minTemp)
        val maxTemp = findViewById<TextView>(R.id.maxTemp)
        val weatherCondition = findViewById<TextView>(R.id.weatherCondition)
        val backButton = findViewById<Button>(R.id.back)

        val days = intent.getStringArrayListExtra("days")
        val minTemps = intent.getIntegerArrayListExtra("minTemps")
        val maxTemps = intent.getIntegerArrayListExtra("maxTemps")
        val weatherConditions = intent.getStringArrayListExtra("weatherConditions")
        val position = intent.getIntExtra("position", -1)

        if (days != null) {
            if (position != -1 && position < days.size) {
                day.text = " Week Day: ${days?.get(position)}"
                minTemp.text = "Minimum Temperature: ${minTemps?.get(position)}°C"
                maxTemp.text = "Maximum Temperature: ${maxTemps?.get(position)}°C"
                weatherCondition.text = "Weather Condition: ${weatherConditions?.get(position)}"
            }
        }

        backButton.setOnClickListener {
            finish()
        }
    }
}
