package otus.gpb.homework.fragments

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment

class FragmentAA : Fragment(R.layout.fragment_a_a) {

    private lateinit var openChildFragmentABBtn: Button
    private lateinit var nameOfFragmentTextView: TextView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val value = arguments?.getInt(ARG_VALUE) ?: Color.WHITE
        view.setBackgroundColor(value)

        openChildFragmentABBtn = view.findViewById(R.id.openChildFragmentABBtn)
        nameOfFragmentTextView = view.findViewById(R.id.nameOfFragmentAATextView)

        openChildFragmentABBtn.text = getString(R.string.open_fragment, "AB")
        nameOfFragmentTextView.text = getString(R.string.name_of_fragment, "AA")

        val randomColor = ColorGenerator.generateColor()
        openChildFragmentABBtn.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.childFragmentABContainer, FragmentAB.create(randomColor))
                .addToBackStack(null)
                .commit()
        }
    }

    companion object {

        private const val ARG_VALUE = "value"

        fun create(color: Int): FragmentAA {
            val fragment = FragmentAA()
            val arguments = Bundle()
            arguments.putInt(ARG_VALUE, color)
            fragment.arguments = arguments
            return fragment
        }
    }
}