package otus.gpb.homework.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

private const val ARG_PARAM = "color"

class FragmentAA : Fragment() {

    private var param: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param = it.getInt(ARG_PARAM)

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_a_a, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (param != null){
            view.setBackgroundColor(param as Int)
        }

        view.findViewById<Button>(R.id.openAB_btn).setOnClickListener{
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, FragmentAB.newInstance(ColorGenerator.generateColor()), "AB")
                .addToBackStack(null)
                .commit()
        }

    }

    companion object {

        @JvmStatic
        fun newInstance(param: Int) =
            FragmentAA().apply {
                arguments = Bundle().apply {
                    putInt(ARG_PARAM, param)

                }
            }
    }
}