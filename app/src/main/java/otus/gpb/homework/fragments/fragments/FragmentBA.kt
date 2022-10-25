package otus.gpb.homework.fragments.fragments

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import otus.gpb.homework.fragments.databinding.FragmentBaBinding
import otus.gpb.homework.fragments.navigator.navigator

class FragmentBA : Fragment() {
    lateinit var binding: FragmentBaBinding
    val myViewModel by viewModels<FragmentBAViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBaBinding.inflate(inflater, container, false)
        if (savedInstanceState != null) {
            updateUI()
        }
        binding.buttonGoBB.setOnClickListener {
            navigator().launchFragment(parentFragmentManager, FragmentBB(), null)
        }
        parentFragmentManager.setFragmentResultListener(FragmentBB.REQUEST_KEY, viewLifecycleOwner) { _, result ->
            val getColor = result.getInt(FragmentBB.BUNDLE_KEY)
            myViewModel.getColor(getColor)
            updateUI()
        }
        return binding.root
    }

    private fun updateUI() {
        binding.layoutBA.setBackgroundColor(myViewModel.color.value ?: Color.CYAN)
    }
}
