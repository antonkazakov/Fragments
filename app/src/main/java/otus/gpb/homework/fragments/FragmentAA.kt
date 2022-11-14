package otus.gpb.homework.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.activity.OnBackPressedCallback

class FragmentAA : Fragment(R.layout.fragment_a_a) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val color = arguments?.getInt(COLOR)
        if (color != null) {
            view.setBackgroundColor(color)
        }

        view.findViewById<Button>(R.id.fragment_ab_btn).setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_ab_container, FragmentAB.instance(ColorGenerator.generateColor()))
                .addToBackStack("FragmentAB")
                .commit()
        }
    }

    companion object {

        private const val COLOR = "color"

        fun instance(color: Int): FragmentAA {
            val fragment = FragmentAA()
            val arguments = Bundle()
            arguments.putInt(COLOR, color)
            fragment.arguments = arguments
            return fragment
        }
    }
}