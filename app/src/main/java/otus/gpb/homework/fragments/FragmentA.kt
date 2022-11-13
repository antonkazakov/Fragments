package otus.gpb.homework.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import com.google.android.material.button.MaterialButton

class FragmentA: Fragment() {
    companion object {
        private const val TAG = "Fragment A"
        const val BACKSTACK_TAG = "fragment_A"
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        val callback = requireActivity().onBackPressedDispatcher.addCallback(this) {
            if (childFragmentManager.backStackEntryCount == 0 &&
                parentFragmentManager.backStackEntryCount <= 1) {
                requireActivity().finish()
            } else {
                childFragmentManager.popBackStack()
            }
        }
        callback.isEnabled = true
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_a, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        view.findViewById<MaterialButton>(R.id.open_fragment_aa).setOnClickListener {
            if (childFragmentManager.findFragmentByTag(FragmentAA.BACKSTACK_TAG) == null) {
                childFragmentManager.beginTransaction()
                    .replace(
                        R.id.fragment_a_container,
                        ColoredFragmentsCreator.createColoredFragment(
                            ColorGenerator.generateColor(), FragmentAA::class.java
                        ), FragmentAA.BACKSTACK_TAG
                    )
                    .addToBackStack(FragmentAA.BACKSTACK_TAG)
                    .commit()
            }
        }
    }
}