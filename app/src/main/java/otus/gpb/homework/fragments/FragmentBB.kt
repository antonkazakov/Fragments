package otus.gpb.homework.fragments

import android.content.res.Configuration
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import otus.gpb.homework.fragments.MainActivity.Companion.COLOR
import otus.gpb.homework.fragments.MainActivity.Companion.RESULT_BA

class FragmentBB : Fragment(R.layout.fragment_b_b) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val sendColor = view.findViewById<Button>(R.id.button_send_color)

        sendColor.setOnClickListener {
            val colorToFragmentBA = Bundle()
            colorToFragmentBA.putInt(COLOR, ColorGenerator.generateColor())
            parentFragmentManager.setFragmentResult(RESULT_BA, colorToFragmentBA)

            if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
                parentFragmentManager.popBackStack()
            }
        }
    }
}