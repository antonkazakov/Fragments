package otus.gpb.homework.fragments.fragments

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import otus.gpb.homework.fragments.databinding.FragmentAaBinding
import otus.gpb.homework.fragments.generator
import otus.gpb.homework.fragments.navigator.navigator

class FragmentAA : Fragment() {
    lateinit var binding: FragmentAaBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAaBinding.inflate(inflater, container, false)
        setBackground()
        binding.buttonGoAB.setOnClickListener {
            val colorSend = generator().generate()
            navigator().launchFragment(parentFragmentManager, FragmentAB(), colorSend)
        }
        return binding.root
    }
    /*
    Method set Background to this fragment. It gets value of color from got arguments
     */
    private fun setBackground() {
        val colorGet = arguments?.getInt(COLOR_ARG)
        binding.layoutAA.setBackgroundColor(colorGet ?: Color.BLACK)
    }

    companion object {
        const val COLOR_ARG = "COLOR_ARG"
        val TAG = FragmentAA::class.java.name

        fun newInstance(colorCode: Int): FragmentAA {
            val args = Bundle()
            args.putInt(COLOR_ARG, colorCode)
            val fragment = FragmentAA()
            fragment.arguments = args
            return fragment
        }
    }
}
