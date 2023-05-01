package com.example.healtec_meddy

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.widget.SearchView
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.ListView
import java.util.Objects

class Search : AppCompatActivity() {

    lateinit var searchView: SearchView
    lateinit var listView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
        searchView = findViewById(R.id.searchView)
        listView = findViewById(R.id.itemList)

        val imageView = findViewById<ImageView>(R.id.backButton)

        imageView.setOnClickListener {
            // Start the other activity
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val meds = arrayOf("Valdres", "Valtrex", "Valvir", "Valacyclovir", "Decadryl", "Biogesic")

        val medsAdapter : ArrayAdapter<String> = ArrayAdapter(
            this,android.R.layout.simple_list_item_1,
            meds
        )

        listView.adapter = medsAdapter;

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                // Perform the search using the query string
                searchView.clearFocus()
                if (meds.contains(query)){
                    medsAdapter.filter.filter(query)
                }
                return false
            }
            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText.isNullOrEmpty()) {
                    listView.visibility = View.GONE // Hide the ListView
                } else {
                    listView.visibility = View.VISIBLE // Show the ListView
                    medsAdapter.filter.filter(newText)
                }
                return false
            }
        })

    }
}