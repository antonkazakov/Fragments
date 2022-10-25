package otus.gpb.homework.fragments

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModelProvider
import otus.gpb.homework.fragments.fragments.*
import otus.gpb.homework.fragments.navigator.Navigator

class MainActivity : AppCompatActivity(), Generator, Navigator {
    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        if (savedInstanceState != null) {
            if (supportFragmentManager.backStackEntryCount > 0) {
                findViewById<Button>(R.id.buttonGoA).visibility = View.INVISIBLE
            }
        }

        findViewById<Button>(R.id.buttonGoA).setOnClickListener {
            launchFragment(supportFragmentManager, FragmentA(), null)
            it.visibility = View.INVISIBLE
        }
    }

    override fun generate(): Int {
        val color = ColorGenerator.generateColor()
        return color
    }

    /*
    *** Here you can choose which fragments you need to open
     */
    override fun launchFragment(fragmentManager: FragmentManager, fragment: Fragment, arg: Int?) {
        when (fragment) {
            is FragmentAA -> launchFragmentWithColor(
                fragmentManager,
                FragmentAA.newInstance(arg ?: return), FragmentAA.TAG
            )
            is FragmentAB -> launchFragmentWithColor(
                fragmentManager,
                FragmentAB.newInstance(arg ?: return), null
            )
            is FragmentBB -> launchFragmentTOP(fragmentManager, fragment)
            is FragmentA -> launchMainFragment(fragmentManager, fragment)
        }
        fragmentManager.beginTransaction()
    }

    /*
    *** If you need to open main fragment - FragmentA - use this method
     */
    private fun launchMainFragment(fragmentManager: FragmentManager, fragment: Fragment) {
        fragmentManager.beginTransaction()
            .setReorderingAllowed(true)
            .addToBackStack(null)
            .add(
                R.id.fragmentConteiner,
                fragment
            )
            .commit()
    }

    /*
   *** If you need to open child fragments of FragmentA - FragmentAA, FragmentAB and another fragments like these,
   use this method.
   *** tag: String? need you for launch child fragment FragmentAA. Later, this helps FragmentA  to understand that need
 show a button when first child fragment (FragmentAA) will been closed.*/
    private fun launchFragmentWithColor(
        fragmentManager: FragmentManager,
        fragment: Fragment,
        tag: String?
    ) {
        fragmentManager.beginTransaction()
            .addToBackStack(null)
            .replace(
                R.id.childAA,
                fragment, tag
            )
            .setReorderingAllowed(true)
            .commit()
    }
    private fun launchFragmentTOP(
        fragmentManager: FragmentManager,
        fragment: Fragment,
    ) {
        fragmentManager.beginTransaction()
            .addToBackStack(null)
            .replace(
                R.id.childBA,
                fragment
            )
            .setReorderingAllowed(true)
            .commit()
    }
/*
*** Here you can override logic onBackPressed - use handleOnBackPressed.
*** Here in handleOnBackPressed we checked - Does FragmentA have child fragments.
*** If he has, we checked is open firs child fragment (was used tag of FragmentAA)
 */
    override fun goBackMain(fragmentManager: FragmentManager) {
        onBackPressedDispatcher.addCallback(
            this,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    Log.d("TAG", "Fragment back pressed invoked")
                    if (fragmentManager.backStackEntryCount > 0) {
                        // return true if user closed FragmentAA
                        if (fragmentManager.findFragmentByTag(FragmentAA.TAG)?.isVisible ?: false)
                            viewModel.mainIsShow(true)
                        fragmentManager.popBackStack()
                    } else {
                        finish()
                    }
                }
            }
        )
    }
    override fun isShow(b: Boolean) {
        viewModel.mainIsShow(b)
    }
}
