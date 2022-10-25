package otus.gpb.homework.fragments.navigator

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

/*
This interface works like navigator - it opens and closes Fragments
MainActivity implements this interface
 */
fun Fragment.navigator():Navigator{
    return requireActivity() as Navigator
}

interface Navigator {
    fun launchFragment(fragmentManager: FragmentManager,fragment: Fragment, arg: Int?)
    fun goBackMain(fragmentManager: FragmentManager)
    fun isShow(b:Boolean)
}