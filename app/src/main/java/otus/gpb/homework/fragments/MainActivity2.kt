package otus.gpb.homework.fragments

import android.content.res.Configuration
import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity2 : AppCompatActivity() {

    private lateinit var fragmentBA: FragmentBA
    private lateinit var fragmentBB: FragmentBB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        fragmentBA = FragmentBA()
        fragmentBB = FragmentBB()

        if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_ba_container, fragmentBA)
                    .replace(R.id.fragment_bb_container, fragmentBB)
                    .addToBackStack(null)
                    .commit()
        } else if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_ba_container, fragmentBA)
                    .addToBackStack(null)
                    .commit()
            }
        }
}