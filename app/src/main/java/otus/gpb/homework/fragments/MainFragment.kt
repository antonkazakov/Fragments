package otus.gpb.homework.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

class MainFragment : Fragment(R.layout.fragment_main) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.fragment_a_btn).setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.activity_container, FragmentA())
                .addToBackStack(null)
                .commit()
        }

        view.findViewById<Button>(R.id.fragment_ba_btn).setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.activity_container, FragmentBA())
                .addToBackStack(null)
                .commit()
        }
    }
}