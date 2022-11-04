package otus.gpb.homework.fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment

class FragmentBA : Fragment(R.layout.fragment_ba) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        parentFragmentManager.setFragmentResultListener("result", this) { _, result ->
            view.setBackgroundColor(result.getInt("color"))
        }
        view.findViewById<Button>(R.id.btnOpenFragmentBB)?.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.Fragment, FragmentBB())
                .addToBackStack(null)
                .commit()
        }
    }
}