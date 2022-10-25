package otus.gpb.homework.fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment

class MyFragmentB: Fragment(R.layout.fragment_a), Showable {

    lateinit var parent: Showable
    private lateinit var layout: ConstraintLayout
    private lateinit var button: Button
    private lateinit var text: TextView
    private var name: String? = null

    companion object {
        fun create(title: String, buttonText: String, color: Int, parent: Showable): Fragment {
            val fragment = MyFragmentB()
            val arguments = Bundle()
            arguments.putString("title", title)
            arguments.putString("buttonText", buttonText)
            arguments.putInt("color", color)
            fragment.arguments = arguments
            fragment.parent = parent
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

        if(name == "FRAGMENT BA") {
            parentFragmentManager.setFragmentResultListener("changeColor", this) {_, res ->
                layout.setBackgroundColor(res.getInt("color"))
            }
        }
        button.setOnClickListener {
            hideAll()
            when(name) {
                "FRAGMENT BA" -> {
                    parentFragmentManager.beginTransaction()
                        .add(R.id.main_frame, create("FRAGMENT BB",
                            "Change BA color and go back", ColorGenerator.generateColor(), this))
                        .addToBackStack("BB")
                        .commit()
                }
                "FRAGMENT BB" -> {
                    val bundle = Bundle()
                    bundle.putInt("color", ColorGenerator.generateColor())
                    requireActivity().supportFragmentManager.setFragmentResult("changeColor", bundle)
                    requireActivity().supportFragmentManager.popBackStack()
                }
            }
        }
    }

    override fun onDestroy() {
        parent.showAll()
        super.onDestroy()
    }

    override fun hideAll() {
        button.visibility = View.INVISIBLE
        text.visibility = View.INVISIBLE
    }

    override fun showAll() {
        button.visibility = View.VISIBLE
        text.visibility = View.VISIBLE
    }
}