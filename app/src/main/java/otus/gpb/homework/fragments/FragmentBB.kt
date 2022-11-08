package otus.gpb.homework.fragments

import android.content.res.Configuration
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment

class FragmentBB : Fragment(R.layout.fragment_b_b), ColorReciver {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val sendColor = view.findViewById<Button>(R.id.button_send_color)

        sendColor.setOnClickListener {
            val colorToFragmentBA = Bundle()
            colorToFragmentBA.putInt(ColorReciver.COLOR, ColorGenerator.generateColor())
            parentFragmentManager.setFragmentResult(ColorReciver.RESULT_BA, colorToFragmentBA)

            if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
                parentFragmentManager.popBackStack()
            }
        }
    }
}