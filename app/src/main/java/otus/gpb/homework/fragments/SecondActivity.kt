package otus.gpb.homework.fragments

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import otus.gpb.homework.fragments.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        initFragments()
        setContentView(binding.root)
    }

    private fun initFragments() {
        addFragmentBA()
        if (binding.containerDetails != null) {
            addFragmentBB()
        }
    }

    private fun addFragmentBA() {
        supportFragmentManager.beginTransaction()
            .add(R.id.container, FragmentBA.newInstance())
            .commit()
    }

    private fun addFragmentBB() {
        supportFragmentManager.beginTransaction()
            .add(R.id.container_details, FragmentBB.newInstance())
            .commit()
    }
}
