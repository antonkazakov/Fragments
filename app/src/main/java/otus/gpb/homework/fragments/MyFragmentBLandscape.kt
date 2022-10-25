package otus.gpb.homework.fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment

class MyFragmentBLandscape: Fragment(R.layout.fragment_a) {

    private lateinit var layout: ConstraintLayout
    private lateinit var button: Button
    private lateinit var text: TextView
    private var name: String? = null

    companion object {
        fun create(title: String, buttonText: String, color: Int): Fragment {
            val fragment = MyFragmentBLandscape()
            val arguments = Bundle()
            arguments.putString("title", title)
            arguments.putString("buttonText", buttonText)
            arguments.putInt("color", color)
            fragment.arguments = arguments
            return fragment
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        text = view.findViewById(R.id.fragment_text_view)
        button = view.findViewById(R.id.fragment_button)
        name = arguments?.getString("title")
        layout = view.findViewById(R.id.fragment_layout)

        text.text = name
        button.text = arguments?.getString("buttonText")
        arguments?.getInt("color")?.let { layout.setBackgroundColor(it) }

        if(name == "LEFT") {
            parentFragmentManager.setFragmentResultListener("changeColorLeft", this) {_, res ->
                layout.setBackgroundColor(res.getInt("color"))
            }
        } else if(name == "RIGHT"){
            parentFragmentManager.setFragmentResultListener("changeColorRight", this) {_, res ->
                layout.setBackgroundColor(res.getInt("color"))
            }
        }
        button.setOnClickListener {
            val bundle = Bundle()
            bundle.putInt("color", ColorGenerator.generateColor())
            when(name) {
                "LEFT" -> {
                    parentFragmentManager.setFragmentResult("changeColorRight", bundle)
                }
                "RIGHT" -> {
                    parentFragmentManager.setFragmentResult("changeColorLeft", bundle)
                }
            }
        }
    }
}