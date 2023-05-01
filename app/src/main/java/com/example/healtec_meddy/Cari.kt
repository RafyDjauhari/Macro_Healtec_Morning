package com.example.healtec_meddy

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.cardview.widget.CardView
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController

class Cari : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_cari, container, false)

        // Get reference to the button
        val button = view.findViewById<LinearLayout>(R.id.searchButton)

        val itemOneBtn = view.findViewById<CardView>(R.id.item_1)

        // Set an onClickListener to the button
        button.setOnClickListener {
            // Start the other activity
            val intent = Intent(activity, Search::class.java)
            startActivity(intent)
        }

        itemOneBtn.setOnClickListener {
            val newFragment = Cari2()
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.cari_1, newFragment)?.commit()
        }

        return view
    }

}