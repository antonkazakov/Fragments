package otus.gpb.homework.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.google.android.material.button.MaterialButton

private const val COLOR = "color"

class FragmentAA : Fragment() {

    private var color: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let { bundle ->
            color = bundle.getInt(COLOR)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_a_a, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val frameLayout = view.findViewById<FrameLayout>(R.id.frame_layout_a_a)
        color?.let {
            frameLayout.setBackgroundColor(it)
        }

        view.findViewById<MaterialButton>(R.id.open_fragment_a_b).setOnClickListener {
            val color = ColorGenerator.generateColor()
            parentFragmentManager.beginTransaction()
                .add(R.id.fragment_a_b_container_view, FragmentAB.newInstance(color))
                .addToBackStack(null)
                .commit()
        }
    }

    companion object {
        fun newInstance(color: Int) =
            FragmentAA().apply {
                arguments = bundleOf(COLOR to color)
            }
    }

}
