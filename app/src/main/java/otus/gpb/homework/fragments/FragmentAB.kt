package otus.gpb.homework.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class FragmentAB : Fragment() {

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
        return inflater.inflate(R.layout.fragment_ab, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        colorId?.let { view.setBackgroundColor(it) }
    }

    companion object{

        private const val COLOR_ID = "ColorId"

        fun newInstance(colorId: Int):FragmentAB{
            return FragmentAB().apply {
                arguments = Bundle().apply {
                    putInt(COLOR_ID, colorId)
                }
            }
        }
    }
}