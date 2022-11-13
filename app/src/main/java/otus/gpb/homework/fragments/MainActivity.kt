package otus.gpb.homework.fragments

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {
    companion object {
        private const val TAG = "MainActivity"
    }

    private lateinit var fA: FragmentA

    private lateinit var buttonOpenFragmentA: MaterialButton
    private lateinit var buttonOpenTask2: MaterialButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fA = FragmentA()

        buttonOpenFragmentA = findViewById(R.id.open_fragment_a)
        buttonOpenFragmentA.setOnClickListener {
            if (supportFragmentManager.findFragmentByTag(FragmentA.BACKSTACK_TAG) == null) {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.activity_container, fA, FragmentA.BACKSTACK_TAG)
                    .addToBackStack(FragmentA.BACKSTACK_TAG)
                    .commit()
            }
        }

        buttonOpenTask2 = findViewById(R.id.open_task_2)
        buttonOpenTask2.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }
    }
}