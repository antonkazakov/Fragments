package otus.gpb.homework.fragments

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var firstTaskButton: Button
    private lateinit var secondTaskButton: Button
    private lateinit var fragmentA: FragmentA

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fragmentA = FragmentA()

        firstTaskButton = findViewById(R.id.firstTaskButton)
        secondTaskButton = findViewById(R.id.secondTaskButton)

        firstTaskButton.text = getString(R.string.fragment_task, 1)
        secondTaskButton.text = getString(R.string.fragment_task, 2)

        firstTaskButton.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, fragmentA)
                .addToBackStack(null)
                .commit()
        }
    }
}