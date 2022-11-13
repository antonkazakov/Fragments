package otus.gpb.homework.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import otus.gpb.homework.fragments.databinding.FragmentAaBinding

class FragmentAA : Fragment() {
    companion object {
        private const val ARG_COLOR = "color"
        const val TAG = "FragmentAA"

        fun newInstance(color: Int) =
            FragmentAA().apply {
                arguments = bundleOf(ARG_COLOR to color)
            }
    }

    private lateinit var binding: FragmentAaBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAaBinding.inflate(inflater, container, false)
        binding.root.setBackgroundColor(arguments?.getInt(ARG_COLOR) ?: android.R.color.white )

        initListeners()
        return binding.root
    }

    private fun initListeners() {
        binding.button.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.container, FragmentAB.newInstance(ColorGenerator.generateColor()))
                .addToBackStack(FragmentAB.TAG)
                .commit()
        }
    }
}
