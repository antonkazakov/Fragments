package otus.gpb.homework.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class FragmentBA : Fragment() {
    private lateinit var fragmentBB: FragmentBB
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.activity_fragment_ba, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        parentFragmentManager.setFragmentResultListener("requestColor", this) { _, result ->
            val color = result.getInt("color")
            view.findViewById<View>(R.id.fragmentBA).setBackgroundColor(color)
        }

        fragmentBB = FragmentBB()
        view.findViewById<Button>(R.id.open_fragment_bb)?.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_ba_container, fragmentBB)
                .addToBackStack(null)
                .commit()
        }
    }

}