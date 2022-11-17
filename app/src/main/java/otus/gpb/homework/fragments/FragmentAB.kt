package otus.gpb.homework.fragments

import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class FragmentAB : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_ab, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val backgroundColor = arguments?.getInt(BACKGROUND_COLOR_KEY) ?: 0

        view.findViewById<View>(R.id.root_fragment_ab)?.apply {
            background = ColorDrawable(backgroundColor)
        }
    }

    companion object {
        private const val BACKGROUND_COLOR_KEY = "Color"
        fun createInstance(backgroundColor: Int) : FragmentAB {
            return FragmentAB().also { fragment ->
                fragment.arguments = Bundle().also {
                    it.putInt(BACKGROUND_COLOR_KEY, backgroundColor)
                }
            }
        }
    }

}