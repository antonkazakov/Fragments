package otus.gpb.homework.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class FragmentBA: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_ba, container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        parentFragmentManager.setFragmentResultListener(
            COLOR_PARAM,
            viewLifecycleOwner
        ) { _, bundle ->
            val color = bundle.getInt(COLOR_ID)
            view.setBackgroundColor(color)
        }
        view.findViewById<Button>(R.id.button_open_fragment_bb).setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container_b, FragmentBB.newInstance())
                .commit()
        }
    }
    companion object{

        const val COLOR_ID = "ColorId"
        const val COLOR_PARAM = "ColorParam"

        fun newInstance():FragmentBA{
            return FragmentBA()
        }

    }
}