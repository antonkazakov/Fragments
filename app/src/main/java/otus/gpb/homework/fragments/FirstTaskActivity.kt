package otus.gpb.homework.fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity

class FirstTaskActivity : AppCompatActivity() {

    lateinit var fragmentA: FragmentA

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_task)

        if(savedInstanceState == null) {
            fragmentA = FragmentA()
        } else {
            fragmentA = supportFragmentManager.findFragmentByTag("FragmentA") as FragmentA
        }

        findViewById<Button>(R.id.fragment_a_open_button)?.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_root_container, fragmentA)
                .addToBackStack(null)
                .commit()
            it.visibility = View.GONE
        }

        this.onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true){
            override fun handleOnBackPressed() {
                if (supportFragmentManager.backStackEntryCount > 0 && fragmentA.childFragmentManager.backStackEntryCount > 1) {
                    fragmentA.childFragmentManager.popBackStack()
                } else {
                    finish()
                }
            }
        })
    }
}