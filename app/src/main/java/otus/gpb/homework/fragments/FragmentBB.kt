package otus.gpb.homework.fragments

import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import otus.gpb.homework.fragments.databinding.FragmentBbBinding

class FragmentBB : Fragment() {
    companion object {
        const val TAG = "FragmentBB"
        const val RES_COLOR = "RES_COLOR"
        const val ARG_COLOR = "ARG_COLOR"

        fun newInstance() = FragmentBB()
    }

    private lateinit var binding: FragmentBbBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBbBinding.inflate(inflater, container, false)

        initListeners()
        return binding.root
    }

    private fun initListeners() {
        binding.button.setOnClickListener {
            parentFragmentManager.setFragmentResult(RES_COLOR, bundleOf(ARG_COLOR to ColorGenerator.generateColor()))
            if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
                parentFragmentManager.popBackStack()
            }
        }
    }
}
