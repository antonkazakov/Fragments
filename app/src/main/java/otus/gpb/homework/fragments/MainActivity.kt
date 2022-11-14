package otus.gpb.homework.fragments

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import otus.gpb.homework.fragments.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val fragmentA = FragmentA()

    private val callback = object : OnBackPressedCallback(true) {

        override fun handleOnBackPressed() {
            when {
                fragmentA.childFragmentManager.backStackEntryCount > 0 -> {
                    fragmentA.childFragmentManager.popBackStack()
                    fragmentA.showButtonIfNeed(fragmentA.childFragmentManager.backStackEntryCount)
                }
                else -> finishAffinity()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        onBackPressedDispatcher.addCallback(this, callback)
        binding = ActivityMainBinding.inflate(layoutInflater)
        initListeners()
        setContentView(binding.root)
    }

    private fun initListeners() {
        with(binding) {
            button.setOnClickListener {
                hideButton()
                supportFragmentManager.beginTransaction()
                    .add(R.id.container, fragmentA)
                    .addToBackStack(FragmentA.TAG)
                    .commit()
            }
            buttonSecond.setOnClickListener {
                startActivity(Intent(this@MainActivity, SecondActivity::class.java))
            }
        }
    }

    private fun hideButton() {
        binding.button.visibility = View.GONE
    }
}
