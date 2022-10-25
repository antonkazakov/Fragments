package otus.gpb.homework.fragments

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {

    private var fragment: Fragment? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById<Button>(R.id.btnOpenFragmentA)
        button.setOnClickListener {
            fragment = FragmentA()
            supportFragmentManager.beginTransaction()
                .replace(R.id.frgmtAContainer, fragment!!)
                .commit()
        }
        onBackPressedDispatcher.addCallback(object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                handleBackPress()
            }
        })
    }

    private fun handleBackPress() {
        Log.d("Test", "BackPressed is called")
        val fragmentManager = fragment?.childFragmentManager
        if (fragmentManager == null || fragmentManager.fragments.isEmpty()) {
            finish()
        } else {
            fragmentManager.popBackStack()
        }
    }
}