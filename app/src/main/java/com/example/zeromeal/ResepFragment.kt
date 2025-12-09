package com.example.zeromeal

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ResepFragment : Fragment() {
    private lateinit var resepAdapter: ResepGridAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_resep, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.rv_resep)
        recyclerView.layoutManager = GridLayoutManager(context, 2)

        resepAdapter = ResepGridAdapter(getAllRecipes()) { recipe ->
            openRecipeDetail(recipe)
        }
        recyclerView.adapter = resepAdapter
    }

    private fun getAllRecipes(): List<Recipe> {
        return listOf(
            Recipe(
                "1", "Nasi Goreng Spesial",
                R.drawable.nasi_goreng, 20, 4.8,
                listOf("Nasi", "Telur", "Bawang", "Kecap", "Ayam"),
                listOf("Panaskan minyak", "Tumis bawang", "Masukkan telur", "Tambah nasi", "Sajikan")
            ),
            Recipe(
                "2", "Ayam Kari Bumbu",
                R.drawable.ayam_kari, 45, 4.6,
                listOf("Ayam", "Santan", "Bumbu Kari", "Kentang"),
                listOf("Rebus ayam", "Tumis bumbu", "Masukkan santan", "Masak hingga matang")
            ),
            Recipe(
                "3", "Soto Ayam",
                R.drawable.nasi_goreng, 35, 4.7,
                listOf("Ayam", "Kunyit", "Jahe", "Bawang"),
                listOf("Rebus ayam", "Haluskan bumbu", "Campurkan", "Sajikan")
            ),
            Recipe(
                "4", "Rendang Daging",
                R.drawable.ayam_kari, 120, 4.9,
                listOf("Daging Sapi", "Santan", "Cabai", "Serai"),
                listOf("Haluskan bumbu", "Masak daging", "Tambah santan", "Masak hingga kering")
            )
        )
    }

    private fun openRecipeDetail(recipe: Recipe) {
        val fragment = RecipeDetailFragment.newInstance(recipe)
        parentFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .addToBackStack(null)
            .commit()
    }
}