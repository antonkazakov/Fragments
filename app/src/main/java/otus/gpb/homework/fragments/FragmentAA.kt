package otus.gpb.homework.fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.FrameLayout
import androidx.fragment.app.Fragment


class FragmentAA : Fragment(R.layout.fragment_aa) {
    companion object {
        const val BUNDLE_COLOR = "color"
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val color = requireArguments().getInt(BUNDLE_COLOR)
        view.findViewById<FrameLayout>(R.id.rootView).setBackgroundColor(color)
        val button = view.findViewById<Button>(R.id.btnOpenFragmentAB)
        button.setOnClickListener {
            val color = ColorGenerator.generateColor()
            val fragment = FragmentAB()
            val bundle = Bundle()
            bundle.putInt(FragmentAB.BUNDLE_COLOR, color)
            fragment.arguments = bundle
            parentFragmentManager.beginTransaction()
                .replace(R.id.childFragConteiner, fragment)
                .addToBackStack(null)
                .commit()
        }
    }

}