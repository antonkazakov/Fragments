package otus.gpb.homework.fragments

import android.graphics.Color
import androidx.fragment.app.Fragment
import java.util.Random

fun Fragment.generator(): Generator {
    return requireActivity() as Generator
}
interface Generator {
    fun generate(): Int
}
object ColorGenerator {

    fun generateColor(): Int {
        val nextInt = Random().nextInt(0xffffff + 1)
        val colorCode = String.format("#%06x", nextInt)
        return Color.parseColor(colorCode)
    }
}
