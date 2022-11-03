package otus.gpb.homework.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainerView

class MasterDetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_master_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val container2 = view.findViewById<FragmentContainerView>(R.id.fragment_container_view_2)

        if (container2 != null) {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container_view_1, FragmentBA())
                .replace(R.id.fragment_container_view_2, FragmentBB())
                .commit()
        } else {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container_view_1, FragmentBA())
                .commit()
        }
    }

}
