package otus.gpb.homework.fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.button_to_A)?.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragments_container, FragmentA())
                .addToBackStack(null)
                .commit()
            it.visibility = View.GONE
        }


    }
}