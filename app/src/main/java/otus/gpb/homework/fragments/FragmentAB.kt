package otus.gpb.homework.fragments

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment

class FragmentAB: Fragment(R.layout.fragment_a_b) {

    private lateinit var nameOfFragmentABTextView: TextView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val value = arguments?.getInt(ARG_VALUE) ?: Color.WHITE
        view.setBackgroundColor(value)

        nameOfFragmentABTextView = view.findViewById(R.id.nameOfFragmentABTextView)
        nameOfFragmentABTextView.text = getString(R.string.name_of_fragment, "AB")
    }
    companion object {

        private const val ARG_VALUE = "value"

        fun create(color: Int): FragmentAB {
            val fragment = FragmentAB()
            val arguments = Bundle()
            arguments.putInt(ARG_VALUE, color)
            fragment.arguments = arguments
            return fragment
        }
    }
}