package otus.gpb.homework.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class FragmentAA: Fragment() {

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
        return inflater.inflate(R.layout.fragment_aa, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        backgroundColor.let { view.setBackgroundColor(it) }
        val fragmentABColor = ColorGenerator.generateColor()
        val fragmentAB = FragmentAB.createNewInstance(fragmentABColor)

        view.findViewById<Button>(R.id.button_to_AB)?.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.childs_container, fragmentAB)
                .addToBackStack(null)
                .commit()
        }
    }

    companion object {

        fun createNewInstance(backgroundColor: Int): FragmentAA {
            return FragmentAA().apply {
                arguments = Bundle().apply {
                    putInt("BACKGROUND_COLOR", backgroundColor)
                }
            }
        }


    }
}