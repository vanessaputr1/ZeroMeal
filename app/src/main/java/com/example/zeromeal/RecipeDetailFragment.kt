package com.example.zeromeal

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment

class RecipeDetailFragment : Fragment() {
    private lateinit var recipe: Recipe

    companion object {
        private const val ARG_RECIPE = "recipe"

        fun newInstance(recipe: Recipe): RecipeDetailFragment {
            val fragment = RecipeDetailFragment()
            val args = Bundle()
            args.putSerializable(ARG_RECIPE, recipe as java.io.Serializable)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_recipe_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recipe = arguments?.getSerializable(ARG_RECIPE) as Recipe

        view.findViewById<ImageView>(R.id.iv_recipe_detail).setImageResource(recipe.imageRes)
        view.findViewById<TextView>(R.id.tv_recipe_name).text = recipe.name
        view.findViewById<TextView>(R.id.tv_time_detail).text = "${recipe.cookingTime} menit"
        view.findViewById<TextView>(R.id.tv_rating_detail).text = recipe.rating.toString()

        val ingredientsText = recipe.ingredients.joinToString("\n") { "• $it" }
        view.findViewById<TextView>(R.id.tv_ingredients).text = ingredientsText

        val stepsText = recipe.steps.mapIndexed { index, step ->
            "${index + 1}. $step"
        }.joinToString("\n\n")
        view.findViewById<TextView>(R.id.tv_steps).text = stepsText
    }
}