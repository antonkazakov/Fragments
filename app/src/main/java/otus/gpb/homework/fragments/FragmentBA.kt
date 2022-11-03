package otus.gpb.homework.fragments

import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import com.google.android.material.button.MaterialButton

class FragmentBA : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_b_a, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val frameLayout = view.findViewById<FrameLayout>(R.id.frame_layout_b_a)
        val button = view.findViewById<MaterialButton>(R.id.open_fragment_b_b)

        parentFragmentManager.setFragmentResultListener(
            FRAGMENT_B_A_REQUEST_KEY,
            viewLifecycleOwner
        ) { _, bundle ->
            val color = bundle.getInt(COLOR)
            frameLayout.setBackgroundColor(color)
        }

        if (requireActivity().resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
            button.visibility = View.VISIBLE
            button.setOnClickListener {
                parentFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container_view_1, FragmentBB())
                    .addToBackStack(null)
                    .commit()
            }
        } else {
            button.visibility = View.GONE
        }
    }

    companion object {
        const val FRAGMENT_B_A_REQUEST_KEY = "FragmentBA"
        const val COLOR = "color"
    }

}
