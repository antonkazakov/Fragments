package otus.gpb.homework.fragments.fragments

import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import otus.gpb.homework.fragments.MainViewModel
import otus.gpb.homework.fragments.databinding.FragmentABinding
import otus.gpb.homework.fragments.generator
import otus.gpb.homework.fragments.navigator.navigator

class FragmentA : Fragment() {

    lateinit var binding: FragmentABinding

    // it checks does FragmentA needs to show button open FragmentAA
    lateinit var myVisibleButton: MainViewModel

    override fun onAttach(context: Context) {
        super.onAttach(context)
        navigator().goBackMain(childFragmentManager)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentABinding.inflate(inflater, container, false)
        myVisibleButton = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
        if (savedInstanceState != null) {
            updateUI()
        }
        binding.buttonGoAA.setOnClickListener {
            val color = generator().generate()
            navigator().launchFragment(childFragmentManager, FragmentAA(), color)
            navigator().isShow(false)
            updateUI()
        }
        myVisibleButton.isShow.observe(
            viewLifecycleOwner,
            Observer {
                updateUI()
            }
        )
        return binding.root
    }

    /*
    We check does FragmentA need to show button for start FragmentAA
     */
    private fun updateUI() {
        if (myVisibleButton.isShow.value == true) {
            binding.buttonGoAA.visibility = View.VISIBLE
            if (requireActivity().getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE)
                binding.groupChild?.visibility = View.VISIBLE
            else binding.childBA.visibility = View.VISIBLE
        } else {
            binding.buttonGoAA.visibility = View.INVISIBLE
            if (requireActivity().getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE)
                binding.groupChild?.visibility = View.INVISIBLE
            else binding.childBA.visibility = View.INVISIBLE
        }
    }
}
