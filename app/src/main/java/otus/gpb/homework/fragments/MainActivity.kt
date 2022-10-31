package otus.gpb.homework.fragments

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var fragmentA: FragmentA

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fragmentA = FragmentA()
        findViewById<Button>(R.id.openA_btn1).setOnClickListener {

            supportFragmentManager.beginTransaction()
                .replace(R.id.activity_container, fragmentA, "a")
                .addToBackStack(null)
                .commit()
        }
        findViewById<Button>(R.id.openB_btn).setOnClickListener{
            intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }




    }

    override fun onBackPressed() {

        if (fragmentA.childFragmentManager.backStackEntryCount > 0) {
            fragmentA.childFragmentManager.popBackStack()
        } else if (supportFragmentManager.backStackEntryCount > 0) {
            supportFragmentManager.popBackStack()
        } else {
            finish()
        }


    }
}


