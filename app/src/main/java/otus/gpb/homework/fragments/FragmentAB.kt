package otus.gpb.homework.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import otus.gpb.homework.fragments.databinding.FragmentAbBinding

class FragmentAB : Fragment() {
    companion object {
        private const val ARG_COLOR = "color"
        const val TAG = "FragmentAB"

        fun newInstance(color: Int) =
            FragmentAB().apply {
                arguments = bundleOf(ARG_COLOR to color)
            }
    }

    private lateinit var binding: FragmentAbBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAbBinding.inflate(inflater, container, false)
        binding.root.setBackgroundColor(arguments?.getInt(ARG_COLOR) ?: android.R.color.white )
        return binding.root
    }
}
