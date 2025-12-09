package com.example.zeromeal

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        // Load default fragment
        loadFragment(BerandaFragment())

        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_beranda -> {
                    loadFragment(BerandaFragment())
                    true
                }
                R.id.nav_stok -> {
                    loadFragment(StokFragment())
                    true
                }
                R.id.nav_tambah -> {
                    loadFragment(TambahFragment())
                    true
                }
                R.id.nav_resep -> {
                    loadFragment(ResepFragment())
                    true
                }
                R.id.nav_profil -> {
                    loadFragment(ProfilFragment())
                    true
                }
                else -> false
            }
        }
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}

// Models
data class Ingredient(
    val id: String,
    val name: String,
    val expiryDate: String,
    val daysUntilExpiry: Int,
    val imageRes: Int
)

data class Recipe(
    val id: String,
    val name: String,
    val imageRes: Int,
    val cookingTime: Int,
    val rating: Double,
    val ingredients: List<String>,
    val steps: List<String>
)

data class ShoppingItem(
    val id: String,
    val name: String,
    var isChecked: Boolean = false
)