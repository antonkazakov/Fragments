package otus.gpb.homework.fragments

import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.google.android.material.button.MaterialButton

class FragmentBB : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_b_b, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<MaterialButton>(R.id.send_color).setOnClickListener {
            val color = ColorGenerator.generateColor()
            parentFragmentManager.setFragmentResult(
                FragmentBA.FRAGMENT_B_A_REQUEST_KEY,
                bundleOf(FragmentBA.COLOR to color)
            )

            if (requireActivity().resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
                parentFragmentManager.popBackStack()
            }
        }
    }

}
