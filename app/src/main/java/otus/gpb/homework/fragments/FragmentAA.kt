package otus.gpb.homework.fragments

import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class FragmentAA : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_aa, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val backgroundColor = arguments?.getInt(BACKGROUND_COLOR_KEY) ?: 0

        view.findViewById<View>(R.id.root_fragment_aa)?.apply {
            background = ColorDrawable(backgroundColor)
        }

        val generatedColor = ColorGenerator.generateColor()
        view.findViewById<Button>(R.id.fragment_ab_open_button)?.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_child_container, FragmentAB.createInstance(generatedColor))
                .addToBackStack(null)
                .commit()
        }
    }

    companion object {
        private const val BACKGROUND_COLOR_KEY = "Color"
        fun createInstance(backgroundColor: Int) : FragmentAA {
            return FragmentAA().also { fragment ->
                fragment.arguments = Bundle().also {
                    it.putInt(BACKGROUND_COLOR_KEY, backgroundColor)
                }
            }
        }
    }
}