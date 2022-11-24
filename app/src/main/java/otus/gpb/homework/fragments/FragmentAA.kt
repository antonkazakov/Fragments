package otus.gpb.homework.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class FragmentAA : Fragment() {

    private var colorId: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        colorId = requireArguments().getInt(COLOR_ID)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_aa, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        colorId?.let { view.setBackgroundColor(it) }

        view.findViewById<Button>(R.id.button_open_fragment_ab).setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(
                    R.id.fragment_a_container,
                    FragmentAB.newInstance(ColorGenerator.generateColor()))
                .addToBackStack(null)
                .commit()
        }
    }

    companion object{

        private const val COLOR_ID = "ColorId"

        fun newInstance(colorId: Int): FragmentAA{
            return FragmentAA().apply {
                arguments = Bundle().apply {
                    putInt(COLOR_ID, colorId)
                }
            }
        }
    }
}