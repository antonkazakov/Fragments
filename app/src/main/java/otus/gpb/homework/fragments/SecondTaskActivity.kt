package otus.gpb.homework.fragments

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity

class SecondTaskActivity : AppCompatActivity() {

    private fun initInPortraitMode(firstInstantiation: Boolean) {
        if (firstInstantiation) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_ba_container, FragmentBA())
                .addToBackStack(null)
                .commit()
        }
    }

    private fun initInLandscapeMode(firstInstantiation: Boolean) {

        if (firstInstantiation) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_ba_container, FragmentBA())
                .replace(R.id.fragment_bb_container, FragmentBB())
                .addToBackStack(null)
                .commit()
            return
        }

        val fragment = supportFragmentManager.findFragmentById(R.id.fragment_ba_container)
        if (fragment is FragmentBA) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_bb_container, FragmentBB())
                .commit()
        } else if (fragment is FragmentBB) {
            supportFragmentManager.popBackStack()
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_ba_container, FragmentBA())
                .replace(R.id.fragment_bb_container, FragmentBB())
                .commit()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_task)

        if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
            initInPortraitMode(savedInstanceState == null)
        } else {
            initInLandscapeMode(savedInstanceState == null)
        }

        this.onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (supportFragmentManager.backStackEntryCount > 1) {
                    supportFragmentManager.popBackStack()
                } else {
                    finish()
                }
            }
        })
    }
}