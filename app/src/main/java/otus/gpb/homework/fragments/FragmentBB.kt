package otus.gpb.homework.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class FragmentBB : Fragment() {

    companion object {
        const val COLOR_REQUEST_KEY = "ColorReq"
        const val COLOR_VALUE_KEY = "ColorVal"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_bb, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.send_color_button)?.setOnClickListener {
            val result = Bundle()
            result.putInt(COLOR_VALUE_KEY, ColorGenerator.generateColor())
            parentFragmentManager.setFragmentResult(COLOR_REQUEST_KEY, result)
        }
    }
}