package otus.gpb.homework.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.CookieSyncManager.createInstance
import android.widget.Button
import androidx.fragment.app.Fragment
import java.lang.reflect.Array.newInstance
import java.net.URLClassLoader.newInstance

class FragmentA : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_a, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val generatedColor = ColorGenerator.generateColor()

        view.findViewById<Button>(R.id.open_fragment_aa).setOnClickListener{
            childFragmentManager.beginTransaction()
                .replace(R.id.fragment_aa_container, FragmentAA.newInstance(generatedColor))
                .addToBackStack(null)
                .commit()
            it.visibility = View.GONE
        }
    }
}