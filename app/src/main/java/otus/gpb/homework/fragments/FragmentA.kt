package otus.gpb.homework.fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment

class FragmentA : Fragment(R.layout.fragment_a) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val button = view.findViewById<Button>(R.id.btnOpenFragmentAA)
        button.setOnClickListener {
            val color = ColorGenerator.generateColor()
            val fragment = FragmentAA()
            val bundle = Bundle()
            bundle.putInt(FragmentAA.BUNDLE_COLOR, color)
            fragment.arguments = bundle
            childFragmentManager.beginTransaction()
                .replace(R.id.childFragConteiner, fragment)
                .addToBackStack(null)
                .commit()
        }
    }
}