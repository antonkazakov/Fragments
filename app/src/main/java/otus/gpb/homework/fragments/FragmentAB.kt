package otus.gpb.homework.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class FragmentAB : Fragment() {

    private var backgroundColor: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        backgroundColor = requireArguments().getInt("BACKGROUND_COLOR")
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
        backgroundColor.let { view.setBackgroundColor(it) }

    }

    companion object {
        fun createNewInstance(backgroundColor: Int): FragmentAB {
            return FragmentAB().apply {
                arguments = Bundle().apply {
                    putInt("BACKGROUND_COLOR", backgroundColor)
                }
            }
        }


    }
}