package otus.gpb.homework.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import otus.gpb.homework.fragments.databinding.FragmentABinding

class FragmentA : Fragment() {
    companion object {
        const val TAG = "FragmentA"
    }

    private lateinit var binding: FragmentABinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentABinding.inflate(layoutInflater, container, false)

        initListeners()

        return binding.root
    }

    private fun initListeners() {
        binding.button.setOnClickListener {
            hideButton()
            childFragmentManager.beginTransaction()
                .replace(R.id.container, FragmentAA.newInstance(ColorGenerator.generateColor()))
                .addToBackStack(FragmentAA.TAG)
                .commit()
        }
    }

    private fun hideButton() {
        binding.button.visibility = View.GONE
    }

    fun showButtonIfNeed(backStackEntryCount: Int) {
        if (backStackEntryCount == 1) {
            binding.button.visibility = View.VISIBLE
        }
    }
}
