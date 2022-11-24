package otus.gpb.homework.fragments

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class FragmentContainer : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_container)
        findViewById<Button>(R.id.button_open_fragment_a).setOnClickListener {
            launchFragmentA()
        }
    }

    private fun launchFragmentA(){
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, FragmentA.newInstance())
            .addToBackStack(null)
            .commit()
    }
}