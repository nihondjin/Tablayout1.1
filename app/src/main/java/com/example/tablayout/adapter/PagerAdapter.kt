package com.example.tablayout.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.tablayout.fragments.FisrtFragment
import com.example.tablayout.fragments.SecondFragment
import com.example.tablayout.fragments.ThirdFragment

class PagerAdapter(fragmentActivity: FragmentActivity): FragmentStateAdapter(fragmentActivity){
    override fun getItemCount(): Int {
        return  3
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> FisrtFragment()
            1 -> SecondFragment()
            else -> ThirdFragment()
        }
    }
}