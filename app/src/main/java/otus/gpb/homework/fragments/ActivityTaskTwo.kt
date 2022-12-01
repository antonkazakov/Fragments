package otus.gpb.homework.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentContainerView
import android.content.res.Configuration

class ActivityTaskTwo : AppCompatActivity() {

    private lateinit var fragmentBA: FragmentBA
    private lateinit var fragmentBB: FragmentBB

    private var frameFragmentBB: FragmentContainerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_two)
        frameFragmentBB = findViewById(R.id.fragment_container_view_tag_task_two_fragmentBB)
        if (savedInstanceState == null) {
            fragmentBA = FragmentBA()
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container_view_tag_task_two, fragmentBA, FRAGMENT_BA)
                .addToBackStack(null)
                .commit()
            if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
                fragmentBB = FragmentBB()
                supportFragmentManager.beginTransaction()
                    .replace(
                        R.id.fragment_container_view_tag_task_two_fragmentBB,
                        fragmentBB,
                        FRAGMENT_BB
                    )
                    .addToBackStack(null)
                    .commit()
            }
        } else {
            fragmentBA = supportFragmentManager.findFragmentByTag(FRAGMENT_BA) as FragmentBA
            if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
                fragmentBB = supportFragmentManager.findFragmentByTag(FRAGMENT_BB) as FragmentBB
            }
        }
    }

    companion object {
        private const val FRAGMENT_BA = "fragment_ba"
        private const val FRAGMENT_BB = "fragment_bb"
    }
}