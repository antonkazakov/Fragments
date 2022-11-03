package otus.gpb.homework.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.button.MaterialButton

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<MaterialButton>(R.id.open_task_1).setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.activity_fragment_container_view, FragmentA())
                .addToBackStack(null)
                .commit()
        }
        view.findViewById<MaterialButton>(R.id.open_task_2).setOnClickListener {

        }
    }

}
