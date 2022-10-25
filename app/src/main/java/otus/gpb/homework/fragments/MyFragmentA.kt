package otus.gpb.homework.fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment

class MyFragmentA : Fragment(R.layout.fragment_a), Showable {

    lateinit var parent: Showable
    private lateinit var button: Button
    private lateinit var text: TextView
    private var name: String? = null

    companion object {
        fun create(title: String, buttonText: String, color: Int, parent: Showable): Fragment {
            val fragment = MyFragmentA()
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

        text.text = name
        button.text = arguments?.getString("buttonText")
        arguments?.getInt("color")?.let {
            view.findViewById<ConstraintLayout>(R.id.fragment_layout).setBackgroundColor(it)
        }
        button.setOnClickListener {
            when(name) {
                "FRAGMENT A" -> {
                    hideAll()
                    childFragmentManager.beginTransaction()
                        .add(R.id.fragment_frame, create("FRAGMENT AA",
                            "Open fragment AB", ColorGenerator.generateColor(), this))
                        .addToBackStack("AA")
                        .commit()
                }
                "FRAGMENT AA" -> {
                    hideAll()
                    parentFragmentManager.beginTransaction()
                        .add(R.id.fragment_frame, create("FRAGMENT AB",
                            "That's it", ColorGenerator.generateColor(), this))
                        .addToBackStack("AB")
                        .commit()
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