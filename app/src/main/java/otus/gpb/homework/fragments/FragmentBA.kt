package otus.gpb.homework.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button

class FragmentBA : Fragment(R.layout.fragment_b_a), ColorReciver {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        parentFragmentManager.setFragmentResultListener(ColorReciver.RESULT_BA, this) { _, result ->
            val value = result.getInt(ColorReciver.COLOR)
            view.setBackgroundColor(value)
        }

        view.findViewById<Button>(R.id.button_open_fragment_bb)?.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container_view_tag_task_two, FragmentBB())
                .addToBackStack(null)
                .commit()
        }
    }
}