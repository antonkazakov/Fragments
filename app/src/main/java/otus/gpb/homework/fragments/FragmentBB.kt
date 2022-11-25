package otus.gpb.homework.fragments

import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class FragmentBB: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_bb, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.button_send_color).setOnClickListener {
            val bundle = Bundle()
            bundle.putInt(FragmentBA.COLOR_ID, ColorGenerator.generateColor())
            parentFragmentManager.setFragmentResult(FragmentBA.COLOR_PARAM, bundle)
            if (activity?.resources?.configuration?.orientation ==
                Configuration.ORIENTATION_PORTRAIT)
            {
                parentFragmentManager.beginTransaction()
                    .replace(
                        R.id.fragment_container_b,
                        FragmentBA.newInstance())
                    .commit()
            }
        }
    }
    companion object{
        fun newInstance(): FragmentBB{
            return FragmentBB()
        }
    }
}