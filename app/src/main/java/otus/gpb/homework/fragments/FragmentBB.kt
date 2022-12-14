package otus.gpb.homework.fragments

import android.content.res.Configuration
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult

class FragmentBB : Fragment(R.layout.fragment_bb) {

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setFragmentResultListener(COLOR) { key: String, bundle: Bundle ->
////            color = bundle.getInt(key)
////            fgBg.background = ColorDrawable(color)
//        }
//    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//
//        val color = arguments?.getInt(COLOR)
//        if (color != null) {
//            view.setBackgroundColor(color)
//        }

        view.findViewById<Button>(R.id.fragment_sendcolor_btn).setOnClickListener {
            val color = ColorGenerator.generateColor()
            if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
                setFragmentResult(
                    FragmentBA.COLOR,
                    bundleOf(FragmentBA.COLOR to color)
                )
                parentFragmentManager.beginTransaction()
                    .replace(
                        R.id.activity_container,
                        FragmentBA()
                    )
                    .addToBackStack("FragmentBA")
                    .commit()
            } else {
                parentFragmentManager.setFragmentResult(
                    FragmentBA.REQ,
                    bundleOf(FragmentBA.COLOR to color)
                )
            }
        }
    }

    companion object {

        const val COLOR = "color"

        fun instance(color: Int): FragmentBB {
            val fragment = FragmentBB()
            val arguments = Bundle()
            arguments.putInt(COLOR, color)
            fragment.arguments = arguments
            return fragment
        }
    }
}