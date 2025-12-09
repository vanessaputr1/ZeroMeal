package com.example.zeromeal

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.collections.listOf

class BerandaFragment : Fragment() {
    private lateinit var expiryAdapter: ExpiryAdapter
    private lateinit var recipeAdapter: RecipeAdapter
    private lateinit var shoppingAdapter: ShoppingAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_beranda, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Setup Expiry RecyclerView
        val expiryRecyclerView = view.findViewById<RecyclerView>(R.id.rv_expiry)
        expiryRecyclerView.layoutManager = LinearLayoutManager(context)
        expiryAdapter = ExpiryAdapter(getExpiryItems())
        expiryRecyclerView.adapter = expiryAdapter

        // Setup Recipe RecyclerView
        val recipeRecyclerView = view.findViewById<RecyclerView>(R.id.rv_recipes)
        recipeRecyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        recipeAdapter = RecipeAdapter(getRecipes()) { recipe ->
            openRecipeDetail(recipe)
        }
        recipeRecyclerView.adapter = recipeAdapter

        // Setup Shopping List RecyclerView
        val shoppingRecyclerView = view.findViewById<RecyclerView>(R.id.rv_shopping)
        shoppingRecyclerView.layoutManager = LinearLayoutManager(context)
        shoppingAdapter = ShoppingAdapter(getShoppingItems())
        shoppingRecyclerView.adapter = shoppingAdapter
    }

    private fun getExpiryItems(): List<Ingredient> {
        return listOf(
            Ingredient("1", "Susu Ultra Milk", "Kedaluwarsa dalam 2 hari", 2, R.drawable.milk),
            Ingredient("2", "Roti Tawar Sari Roti", "Kedaluwarsa dalam 3 hari", 3, R.drawable.bread)
        )
    }

    private fun getRecipes(): List<Recipe> {
        return listOf(
            Recipe(
                "1",
                "Nasi Goreng Spesial",
                R.drawable.nasi_goreng,
                20,
                4.8,
                listOf("Nasi", "Telur", "Bawang", "Kecap", "Ayam"),
                listOf(
                    "Panaskan minyak di wajan",
                    "Tumis bawang hingga harum",
                    "Masukkan telur, orak-arik",
                    "Tambahkan nasi dan kecap",
                    "Aduk rata dan sajikan"
                )
            ),
            Recipe(
                "2",
                "Ayam Kari Bumbu",
                R.drawable.ayam_kari,
                45,
                4.6,
                listOf("Ayam", "Santan", "Bumbu Kari", "Kentang", "Wortel"),
                listOf(
                    "Rebus ayam hingga empuk",
                    "Tumis bumbu kari",
                    "Masukkan ayam dan santan",
                    "Tambahkan kentang dan wortel",
                    "Masak hingga bumbu meresap"
                )
            )
        )
    }

    private fun getShoppingItems(): List<ShoppingItem> {
        return listOf(
            ShoppingItem("1", "Beras 5kg"),
            ShoppingItem("2", "Minyak Goreng"),
            ShoppingItem("3", "Telur 1 kg")
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