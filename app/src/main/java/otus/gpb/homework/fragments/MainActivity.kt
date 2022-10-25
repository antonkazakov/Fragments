package otus.gpb.homework.fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById<Button>(R.id.btnOpenFragmentA)
        button.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.frgmtAContainer, FragmentA())
                .commit()
        }
    }
}