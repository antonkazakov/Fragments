package otus.gpb.homework.fragments

import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainerView

class FragmentBA : Fragment() {

    lateinit var rootContainer: View

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_ba, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rootContainer = view.findViewById(R.id.root_fragment_ba)

        parentFragmentManager.setFragmentResultListener(FragmentBB.COLOR_REQUEST_KEY, this) {_, result ->
            val color = result.getInt(FragmentBB.COLOR_VALUE_KEY)
            rootContainer?.apply {
                background = ColorDrawable(color)
            }
        }

        view.findViewById<Button>(R.id.fragment_bb_open_button)?.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_ba_container, FragmentBB())
                .addToBackStack(null)
                .commit()
        }
    }
}