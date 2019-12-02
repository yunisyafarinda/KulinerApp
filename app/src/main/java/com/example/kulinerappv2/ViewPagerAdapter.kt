package com.example.kulinerappv2

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class ViewPagerAdapter (context:Context, fm:FragmentManager):
    FragmentPagerAdapter(fm,  BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT){
    override fun getItem(position: Int): Fragment {
        when(position){
            0 -> return MakananFragment()
            1 -> return MinumanFragment()
        }
        return MakananFragment()
    }

    override fun getCount(): Int {
        return 2
    }

    override fun getPageTitle(position: Int): CharSequence? {
        if(position == 0){
            return "Makanan"
        }
        else if (position == 1){
            return "Minuman"
        }
        return super.getPageTitle(position)
    }
}