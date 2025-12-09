package com.example.zeromeal

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class StokFragment : Fragment() {
    private lateinit var stokAdapter: StokAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_stok, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.rv_stok)
        recyclerView.layoutManager = LinearLayoutManager(context)

        stokAdapter = StokAdapter(getStokItems())
        recyclerView.adapter = stokAdapter
    }

    private fun getStokItems(): List<Ingredient> {
        return listOf(
            Ingredient("1", "Susu Ultra Milk", "31 Des 2024", 2, R.drawable.milk),
            Ingredient("2", "Roti Tawar", "28 Des 2024", 3, R.drawable.bread),
            Ingredient("3", "Telur Ayam", "5 Jan 2025", 10, R.drawable.milk),
            Ingredient("4", "Beras Premium", "15 Feb 2025", 45, R.drawable.bread),
            Ingredient("5", "Minyak Goreng", "20 Jan 2025", 20, R.drawable.milk)
        )
    }
}