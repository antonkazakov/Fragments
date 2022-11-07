package otus.gpb.homework.fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment

class FragmentA : Fragment(R.layout.fragment_a) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val color = ColorGenerator.generateColor()
        val buttonText = getString(R.string.open_fragment_aa, Integer.toHexString(color))
        val openFragmentAAButton = view.findViewById<Button>(R.id.button_open_fragment_aa)
        openFragmentAAButton.text = buttonText
        openFragmentAAButton.setBackgroundColor(color)

        openFragmentAAButton.setOnClickListener {
            childFragmentManager.beginTransaction()
                .replace(R.id.child_fragment_a_container_view_tag, FragmentAA.create(color))
                .addToBackStack("First task")
                .commit()
        }
    }
}