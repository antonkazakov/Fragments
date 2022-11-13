package otus.gpb.homework.fragments

import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import com.google.android.material.button.MaterialButton

class FragmentAA: Fragment() {
    companion object {
        const val BACKSTACK_TAG = "fragment_AA"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_aa, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val bgColor = arguments?.getInt(ColoredFragmentsCreator.ARG_COLOR)?: 0
        view.findViewById<ConstraintLayout>(R.id.fragment_aa_bg).background = ColorDrawable(bgColor)
        view.findViewById<MaterialButton>(R.id.open_fragment_ab).setOnClickListener {
            if (parentFragmentManager.findFragmentByTag(FragmentAB.BACKSTACK_TAG) == null) {
                parentFragmentManager.beginTransaction()
                    .replace(R.id.fragment_a_container,
                        ColoredFragmentsCreator.createColoredFragment(
                            ColorGenerator.generateColor(), FragmentAB::class.java),
                        FragmentAB.BACKSTACK_TAG
                    )
                    .addToBackStack(FragmentAB.BACKSTACK_TAG)
                    .commit()
            }
        }
    }
}