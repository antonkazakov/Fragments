package otus.gpb.homework.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class FragmentA : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_a, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val generatedColor = ColorGenerator.generateColor()

        view.findViewById<Button>(R.id.fragment_aa_open_button)?.setOnClickListener {
            childFragmentManager.beginTransaction()
                .replace(R.id.fragment_child_container, FragmentAA.createInstance(generatedColor))
                .addToBackStack(null)
                .commit()
            it.visibility = View.GONE
        }
    }
}