package otus.gpb.homework.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment

class ColoredFragmentsCreator {
    companion object {
        const val ARG_COLOR = "color"
        fun <T : Fragment> createColoredFragment(color: Int, fragmentClass: Class<T>): T {
            val cFragment = fragmentClass.newInstance()
            val arguments = Bundle()
            arguments.putInt(ARG_COLOR, color)
            cFragment.arguments = arguments
            return cFragment
        }
    }
}