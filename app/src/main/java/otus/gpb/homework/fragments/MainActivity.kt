package otus.gpb.homework.fragments

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.button_taskOne).setOnClickListener {
            startActivity(Intent(this, ActivityTaskOne::class.java))
        }
        findViewById<Button>(R.id.button_taskTwo).setOnClickListener {
            startActivity(Intent(this, ActivityTaskTwo::class.java))
        }
    }
}