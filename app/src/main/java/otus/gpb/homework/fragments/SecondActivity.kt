package otus.gpb.homework.fragments

import android.content.res.Configuration
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class SecondActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            supportFragmentManager.beginTransaction()
                .add(R.id.land_container_left, FragmentBA())
                .add(R.id.land_container_right, FragmentBB())
                .commit()
        } else {
            supportFragmentManager.beginTransaction()
                .add(R.id.port_container, FragmentBA())
                .addToBackStack(null)
                .commit()
        }
    }
}