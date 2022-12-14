package otus.gpb.homework.fragments

import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var mainFragment: MainFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // запуск главного фрагмента
        if (savedInstanceState == null) {
            mainFragment = MainFragment()
            supportFragmentManager.beginTransaction()
                .replace(R.id.activity_container, mainFragment, "mainFragment")
                .commit()
        } else {
            mainFragment = supportFragmentManager.findFragmentByTag("mainFragment") as MainFragment
        }
    }
}