package otus.gpb.homework.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import otus.gpb.homework.fragments.MainActivity.Companion.COLOR
import otus.gpb.homework.fragments.MainActivity.Companion.RESULT_BA

class FragmentBA : Fragment(R.layout.fragment_b_a) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        parentFragmentManager.setFragmentResultListener(RESULT_BA, this) { _, result ->
            val value = result.getInt(COLOR)
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