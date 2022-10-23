package otus.gpb.homework.fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels

class FragmentBA : Fragment(R.layout.fragment_b_a) {

    private lateinit var textView: TextView
    private val viewModel: FragmentsViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        determinePortraitMode()

        viewModel.stateColor.observe(viewLifecycleOwner) {
            view.setBackgroundColor(it)
        }

        textView = view.findViewById(R.id.nameOfFragmentBATextView)
        textView.text = getString(R.string.name_of_fragment, "BA")
    }

    private fun determinePortraitMode() {
        val button = view?.findViewById<Button>(R.id.openFragmentBtn)
        if (button != null) {
            button.text = getString(R.string.open_fragment, "BB")
            button.setOnClickListener {
                parentFragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainer, FragmentBB())
                    .addToBackStack(null)
                    .commit()
            }
        }
    }
}
