package otus.gpb.homework.fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.FrameLayout
import android.widget.TextView
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), Showable {

    private lateinit var button: Button
    private lateinit var button2: Button
    private lateinit var text: TextView
    private val fragment = MyFragmentA.create(
        "FRAGMENT A", "Open fragment AA",
        ColorGenerator.generateColor(), this)


    private val callback = object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            if (fragment.childFragmentManager.backStackEntryCount > 0)
                fragment.childFragmentManager.popBackStack()
            else
                finishAffinity()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val isPortrait = findViewById<FrameLayout>(R.id.main_frame_landscape_left) == null
        if (isPortrait) makePortrait()
        else makeLandscape()
    }

    private fun makePortrait() {
        button = findViewById(R.id.main_button)
        button2 = findViewById(R.id.main_button_second)
        text = findViewById(R.id.main_text_view)

        button.setOnClickListener {
            onBackPressedDispatcher.addCallback(this, callback)
            hideAll()
            supportFragmentManager.beginTransaction()
                .add(R.id.main_frame, fragment)
                .addToBackStack("A")
                .commit()
        }

        button2.setOnClickListener {
            hideAll()
            supportFragmentManager.beginTransaction()
                .add(R.id.main_frame, MyFragmentB.create("FRAGMENT BA", "Open fragment BB",
                    101010, this))
                .addToBackStack("BA")
                .commit()
        }
    }

    private fun makeLandscape() {
        val leftFragment = MyFragmentBLandscape.create("LEFT", "Change color -->", 0)
        val rightFragment = MyFragmentBLandscape.create("RIGHT", "<-- Change color", 0)
        supportFragmentManager.beginTransaction()
            .add(R.id.main_frame_landscape_left, leftFragment)
            .addToBackStack("BLeft")
            .add(R.id.main_frame_landscape_right, rightFragment)
            .addToBackStack("BRight")
            .commit()
    }

    override fun hideAll() {
        button.visibility = View.INVISIBLE
        button2.visibility = View.INVISIBLE
        text.visibility = View.INVISIBLE
    }

    override fun showAll() {
        button.visibility = View.VISIBLE
        button2.visibility = View.VISIBLE
        text.visibility = View.VISIBLE
    }
}

interface Showable {
    fun hideAll()
    fun showAll()
}