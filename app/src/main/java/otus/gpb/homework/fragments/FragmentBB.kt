package otus.gpb.homework.fragments

import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment



class FragmentBB : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_bb, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        view.findViewById<Button>(R.id.button_send_color)?.setOnClickListener {
            val backgroundColor = ColorGenerator.generateColor()
            val bundle = Bundle()
            bundle.putInt(COLOR, backgroundColor)
            parentFragmentManager.setFragmentResult(BACK_COLOR, bundle)
            if (activity?.resources?.configuration?.orientation == Configuration
                    .ORIENTATION_PORTRAIT) {
                parentFragmentManager.beginTransaction()
                    .replace(R.id.portrait_fragments_container, FragmentBA())
                    .commit()
            }
        }
    }
}