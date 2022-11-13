package otus.gpb.homework.fragments

import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment

class FragmentAB: Fragment() {
    companion object {
        const val BACKSTACK_TAG = "fragment_AB"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_ab, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val bgColor = arguments?.getInt(ColoredFragmentsCreator.ARG_COLOR)?: 0
        view.findViewById<ConstraintLayout>(R.id.fragment_ab_bg).background = ColorDrawable(bgColor)
    }


}