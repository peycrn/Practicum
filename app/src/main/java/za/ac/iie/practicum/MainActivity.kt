package za.ac.iie.practicum

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imageView3 = findViewById<ImageView>(R.id.imageView3)
        val button1 = findViewById<Button>(R.id.Button1)
        val textView1 = findViewById<TextView>(R.id.textView1)
        val button2 = findViewById<Button>(R.id.Button2)

        button1.setOnClickListener {
            startActivity(Intent(this, Weather::class.java))
        }

        button2.setOnClickListener {
            finishAffinity() // Close the app
        }
    }
}