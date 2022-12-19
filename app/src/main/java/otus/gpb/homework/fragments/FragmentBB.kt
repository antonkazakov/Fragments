package otus.gpb.homework.fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels

class FragmentBB : Fragment(R.layout.fragment_b_b) {

    private lateinit var button: Button
    private lateinit var textView: TextView
    private val viewModel: FragmentsViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        button = view.findViewById(R.id.sendColorBtn)
        textView = view.findViewById(R.id.nameOfFragmentBBTextView)

        button.text = getString(R.string.send_color)
        textView.text = getString(R.string.name_of_fragment, "BB")

        button.setOnClickListener {
            viewModel.passNewColor(ColorGenerator.generateColor())
        }
    }
}