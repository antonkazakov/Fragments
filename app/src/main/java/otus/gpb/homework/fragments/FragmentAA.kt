package otus.gpb.homework.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button

class FragmentAA : Fragment(R.layout.fragment_a_a) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val colorBackground = arguments?.getInt(ARG_COLOR) ?: 0
        val colorToAB = ColorGenerator.generateColor()
        val buttonText = getString(R.string.open_fragment_ab, Integer.toHexString(colorToAB))
        val openFragmentABButton = view.findViewById<Button>(R.id.button_open_fragment_ab)

        view.setBackgroundColor(colorBackground)
        openFragmentABButton.text = buttonText
        openFragmentABButton.setBackgroundColor(colorToAB)

        openFragmentABButton.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.child_fragment_a_container_view_tag, FragmentAB.create(colorToAB))
                .addToBackStack("First task")
                .commit()
        }
    }


    companion object {

        const val ARG_COLOR = "color"

        fun create(color: Int): FragmentAA {
            val fragment = FragmentAA()
            val arguments = Bundle()
            arguments.putInt(ARG_COLOR, color)
            fragment.arguments = arguments
            return fragment
        }
    }
}