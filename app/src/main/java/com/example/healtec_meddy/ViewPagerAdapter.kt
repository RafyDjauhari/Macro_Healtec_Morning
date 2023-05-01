package com.example.healtec_meddy

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.healtec_meddy.fragments.ApotekFragment
import com.example.healtec_meddy.fragments.KomposisiFragment
import com.example.healtec_meddy.fragments.ObatFragment
import com.example.healtec_meddy.fragments.SemuaFragment

class ViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle): FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int {
        return 4
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> SemuaFragment()
            1 -> ObatFragment()
            2 -> ApotekFragment()
            3 -> KomposisiFragment()
            else -> throw IllegalArgumentException("Invalid position: $position")
        }
    }
}