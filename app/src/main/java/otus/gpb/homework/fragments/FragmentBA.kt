package otus.gpb.homework.fragments

import android.content.res.Configuration.ORIENTATION_PORTRAIT
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import otus.gpb.homework.fragments.databinding.FragmentBaBinding

class FragmentBA : Fragment() {
    companion object {
        fun newInstance() = FragmentBA()
    }

    private lateinit var binding: FragmentBaBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBaBinding.inflate(inflater, container, false)
        binding.button.visibility =
            if (resources.configuration.orientation == ORIENTATION_PORTRAIT) View.VISIBLE else View.GONE

        parentFragmentManager.setFragmentResultListener(FragmentBB.RES_COLOR, viewLifecycleOwner) { _, bundle ->
            binding.root.setBackgroundColor(bundle.getInt(FragmentBB.ARG_COLOR))
        }
        initListeners()
        return binding.root
    }

    private fun initListeners() {
        binding.button.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.container, FragmentBB.newInstance())
                .addToBackStack(FragmentBB.TAG)
                .commit()
        }
    }
}
