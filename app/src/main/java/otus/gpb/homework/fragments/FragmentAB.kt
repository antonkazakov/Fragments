package otus.gpb.homework.fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.FrameLayout
import androidx.fragment.app.Fragment


class FragmentAB : Fragment(R.layout.fragment_ab) {
    companion object {
        const val BUNDLE_COLOR = "color"
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val color = requireArguments().getInt(BUNDLE_COLOR)
        view.findViewById<FrameLayout>(R.id.rootView).setBackgroundColor(color)
    }
}