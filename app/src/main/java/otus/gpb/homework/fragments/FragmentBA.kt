package otus.gpb.homework.fragments

import android.content.res.Configuration
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener

class FragmentBA : Fragment(R.layout.fragment_ba) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setFragmentResultListener(COLOR) { key: String, bundle: Bundle ->
            view?.setBackgroundColor(bundle.getInt(key))
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
            view.findViewById<Button>(R.id.fragment_sendcolor_btn).setOnClickListener {
                parentFragmentManager.beginTransaction()
                    .replace(R.id.activity_container, FragmentBB())
                    .addToBackStack("FragmentBB")
                    .commit()
            }
        } else {

            val linearLayout = view.findViewById<LinearLayout>(R.id.linear)
            childFragmentManager.setFragmentResultListener(REQ, viewLifecycleOwner) { _, bundle ->
                val color = bundle.getInt(COLOR)
                linearLayout.setBackgroundColor(color)
            }

            childFragmentManager.beginTransaction()
                .replace(R.id.fragment_bb_container, FragmentBB())
                .addToBackStack("FragmentBB")
                .commit()
        }
    }

    companion object {

        const val REQ = "FragmentBA"
        const val COLOR = "color"

        fun instance(color: Int): FragmentBA {
            val fragment = FragmentBA()
            val arguments = Bundle()
            arguments.putInt(COLOR, color)
            fragment.arguments = arguments
            return fragment
        }
    }
}