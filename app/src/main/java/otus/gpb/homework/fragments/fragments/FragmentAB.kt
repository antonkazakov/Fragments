package otus.gpb.homework.fragments.fragments

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import otus.gpb.homework.fragments.R

class FragmentAB : Fragment() {
    lateinit var myView: View
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        myView = inflater.inflate(R.layout.fragment_ab, container, false)
        setBackground(myView)

        return myView
    }

    private fun setBackground(v: View) {
        val color = arguments?.getInt(COLOR_ARG)
        v.setBackgroundColor(color ?: Color.BLACK)
    }

    companion object {
        const val COLOR_ARG = "COLOR_ARG"

        fun newInstance(colorCode: Int): FragmentAB {
            val args = Bundle()
            args.putInt(COLOR_ARG, colorCode)
            val fragment = FragmentAB()
            fragment.arguments = args
            return fragment
        }
    }
}
