package otus.gpb.homework.fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var firstTaskButton: Button
    private lateinit var secondTaskButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        firstTaskButton = findViewById(R.id.firstTaskButton)
        secondTaskButton = findViewById(R.id.secondTaskButton)

        firstTaskButton.text = getString(R.string.fragment_task, 1)
        secondTaskButton.text = getString(R.string.fragment_task, 2)

        val firstLandscapeFragmentContainer: View? = findViewById(R.id.landscapeFragmentContainer1)
        val secondLandscapeFragmentContainer: View? = findViewById(R.id.landscapeFragmentContainer2)

        firstTaskButton.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, FragmentA())
                .addToBackStack(null)
                .commit()
        }

        secondTaskButton.setOnClickListener {
            if (firstLandscapeFragmentContainer != null && secondLandscapeFragmentContainer != null) {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.landscapeFragmentContainer1, FragmentBA())
                    .replace(R.id.landscapeFragmentContainer2, FragmentBB())
                    .addToBackStack(null)
                    .commit()
            } else {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainer, FragmentBA())
                    .addToBackStack(null)
                    .commit()
            }
        }
    }
}