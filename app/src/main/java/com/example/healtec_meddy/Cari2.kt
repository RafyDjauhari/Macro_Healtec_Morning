package com.example.healtec_meddy

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.healtec_meddy.databinding.FragmentCari2Binding
import com.example.healtec_meddy.fragments.ApotekFragment
import com.example.healtec_meddy.fragments.KomposisiFragment
import com.example.healtec_meddy.fragments.ObatFragment
import com.example.healtec_meddy.fragments.SemuaFragment
import com.google.android.material.tabs.TabLayoutMediator

class Cari2 : Fragment() {

    private var binding: FragmentCari2Binding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCari2Binding.inflate(inflater, container, false)
        val view = binding!!.root

        val adapter = ViewPagerAdapter(childFragmentManager, lifecycle)
        binding!!.viewPager.adapter = adapter

        TabLayoutMediator(binding!!.tabLayout, binding!!.viewPager) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = "Semua"
                }
                1 -> {
                    tab.text = "Obat"
                }
                2 -> {
                    tab.text = "Apotek"
                }
                3 -> {
                    tab.text = "Komposisi"
                }
            }
        }.attach()

        for (i in 0..3){
            val textView = LayoutInflater.from(requireContext()).inflate(R.layout.tab_title, null)
                    as TextView
            binding!!.tabLayout.getTabAt(i)?.customView = textView
        }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}

