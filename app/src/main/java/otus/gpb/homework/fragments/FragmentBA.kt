package otus.gpb.homework.fragments

import android.content.res.Configuration
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import com.google.android.material.button.MaterialButton

class FragmentBA: Fragment() {
    companion object{
        const val RES_ARG_COLOR = "COLOR"
    }
    private var color: Int = 0xFFFFFF
    private lateinit var fgBg: ConstraintLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setFragmentResultListener(RES_ARG_COLOR) { key: String, bundle: Bundle ->
            color = bundle.getInt(key)
            fgBg.background = ColorDrawable(color)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_ba, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        fgBg = view.findViewById(R.id.fragment_ba_bg)
        // На случай, если кнопка SendColor не была нажата и возращаемся из FragmentBB
        fgBg.background = ColorDrawable(color)
        if (resources.configuration.orientation != Configuration.ORIENTATION_LANDSCAPE) {
            view.findViewById<MaterialButton>(R.id.open_fragment_bb).setOnClickListener {
                parentFragmentManager.beginTransaction()
                    .replace(R.id.port_container, FragmentBB())
                    .addToBackStack(null)
                    .commit()
            }
        }
    }
}