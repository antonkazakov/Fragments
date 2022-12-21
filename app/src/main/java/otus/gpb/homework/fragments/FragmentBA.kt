package otus.gpb.homework.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

const val BACK_COLOR = "BACK_COLOR"
const val COLOR = "COLOR"

class FragmentBA : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_ba, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        parentFragmentManager.setFragmentResultListener(BACK_COLOR, viewLifecycleOwner) {_, bundle ->
            val backgroundColor = bundle.getInt(COLOR)
            view.setBackgroundColor(backgroundColor)
        }

        view.findViewById<Button>(R.id.button_to_BB)?.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.portrait_fragments_container, FragmentBB())
                .commit()
        }
    }
}