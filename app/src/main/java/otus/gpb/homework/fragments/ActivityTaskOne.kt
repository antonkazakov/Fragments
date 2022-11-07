package otus.gpb.homework.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.OnBackPressedCallback

class ActivityTaskOne : AppCompatActivity() {

    private lateinit var fragmentA: FragmentA

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_one)

        if (savedInstanceState == null) {
            fragmentA = FragmentA()
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container_view_tag, fragmentA, FRAGMENT_A)
                .addToBackStack(null)
                .commit()
        } else {
            fragmentA = supportFragmentManager.findFragmentByTag(FRAGMENT_A) as FragmentA
        }
        this.onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (fragmentA.childFragmentManager.backStackEntryCount > 0) {
                    fragmentA.childFragmentManager.popBackStack()
                } else {
                    finish()
                }
            }
        })
    }

    companion object {
        const val FRAGMENT_A = "fragmentA"
    }
}