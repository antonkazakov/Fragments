package otus.gpb.homework.fragments

import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import com.google.android.material.button.MaterialButton

class FragmentBB: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_bb, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<MaterialButton>(R.id.button_send_color).setOnClickListener {
            val color = ColorGenerator.generateColor()
            setFragmentResult(FragmentBA.RES_ARG_COLOR,
                bundleOf( FragmentBA.RES_ARG_COLOR to color ) )
            if (resources.configuration.orientation != Configuration.ORIENTATION_LANDSCAPE) {
                parentFragmentManager.popBackStack()
            }
        }
    }

}