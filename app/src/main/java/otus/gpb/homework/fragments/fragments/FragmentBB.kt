package otus.gpb.homework.fragments.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import otus.gpb.homework.fragments.databinding.FragmentBbBinding
import otus.gpb.homework.fragments.generator

class FragmentBB : Fragment() {
    lateinit var binding: FragmentBbBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBbBinding.inflate(inflater, container, false)
        binding.buttonSendColor.setOnClickListener {
            val color = generator().generate()
            parentFragmentManager.setFragmentResult(REQUEST_KEY, bundleOf(BUNDLE_KEY to color))
            parentFragmentManager.popBackStack()
        }

        return binding.root
    }
    companion object {
        const val REQUEST_KEY = "REQUEST_KEY"
        const val BUNDLE_KEY = "BUNDLE_KEY"
    }
}
