package otus.gpb.homework.fragments

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.btnTask1).setOnClickListener {
            startActivity(Intent(this, Task1Activity::class.java))
        }
        findViewById<Button>(R.id.btnTask2).setOnClickListener {
            startActivity(Intent(this, Task2Activity::class.java))
        }
    }
}