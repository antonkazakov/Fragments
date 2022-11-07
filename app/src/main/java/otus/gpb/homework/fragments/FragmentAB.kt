package otus.gpb.homework.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment

class FragmentAB : Fragment(R.layout.fragment_a_b) {
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val colorBackground = arguments?.getInt(ArgValue.ARG_COLOR)
        view.setBackgroundColor(colorBackground!!)
    }

    companion object {

        fun create(color: Int): FragmentAB {
            val fragment = FragmentAB()
            val arguments = Bundle()
            arguments.putInt(ArgValue.ARG_COLOR, color)
            fragment.arguments = arguments
            return fragment
        }
    }

}