package com.example.ordereasy.ui.foodMenu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.ordereasy.R
import com.example.ordereasy.R.layout
import com.example.ordereasy.data.PlatoTipico
import com.google.android.material.switchmaterial.SwitchMaterial

// TODO: Renombra los argumentos de parámetros, elige nombres que coincidan
// con los parámetros de inicialización del fragmento, por ejemplo ARG_ITEM_NUMBER

// Lista de platos locales
private val platosLocales: List<PlatoTipico> = listOf(
    PlatoTipico(1, "Arroz con Pollo", "Delicioso plato típico colombiano", "https://cloudfront-us-east-1.images.arcpublishing.com/elespectador/LDRLW34JWNAPHDQ6I7KOOUJVKI.jpg",true, 12.99),
    PlatoTipico(2, "Ajiaco", "Sopa tradicional bogotana", "https://www.recetasnestle.com.ec/sites/default/files/styles/recipe_detail_desktop/public/srh_recipes/3964b77d9ff84585e562ad1bd1205e25.jpg?itok=dK0dcEr1", false, 15.50),
    PlatoTipico(3, "Bandeja Paisa", "Plato abundante con variedad de carnes", "https://img.lalr.co/cms/2023/08/30200209/datos_1080x900-50.jpg?size=xl&ratio=r40_21", true, 18.90 ),
    PlatoTipico(4, "Lechona Tolimense", "Plato típico del Tolima", "https://www.recetasnestle.com.co/sites/default/files/srh_recipes/aae59a84cb4eaeacc43c307da8522102.jpg", true, 20.00),
    PlatoTipico(5, "Sancocho", "Sopa colombiana con variedad de ingredientes", "https://cloudfront-us-east-1.images.arcpublishing.com/elespectador/NPCOUP725ZBQBCLN6TJ5RUSHHI.jpg", true, 15.00),
    PlatoTipico(6, "Tamal", "Masa de maíz rellena con carne o pollo", "https://colombiavisible.com/wp-content/uploads/2022/04/shutterstock_1176827785-1-1-scaled.jpg", true, 5.00),
    PlatoTipico(7, "Arepa", "Tortilla de maíz", "https://colombiavisible.com/wp-content/uploads/2022/04/shutterstock_1176827785-1-1-scaled.jpg", true, 2.00),
    PlatoTipico(8, "Empanada", "Masa rellena con carne, pollo o queso", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ1GO8AgGflh_LqQcD2V5ZkPe--GShuigxAzl4IMcJhCQ&s", true, 3.00),
    PlatoTipico(9, "Postre de Natas", "Crema de leche con caramelo", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ1GO8AgGflh_LqQcD2V5ZkPe--GShuigxAzl4IMcJhCQ&s", true, 4.00),
    PlatoTipico(10, "Oblea", "Galleta delgada y crujiente", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ1GO8AgGflh_LqQcD2V5ZkPe--GShuigxAzl4IMcJhCQ&s", true, 1.00),
)

/**
 * Un fragmento simple.
 * Utiliza el método de fábrica [FoodCardFragment.newInstance]
 * para crear una instancia de este fragmento.
 */
class FoodCardFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(layout.fragment_food_card, container, false)

        val nombreTextView: TextView = view.findViewById(R.id.nombreTextView)
        val descripcionTextView: TextView = view.findViewById(R.id.descripcionTextView)
        val imagenImageView: ImageView = view.findViewById(R.id.imageImageView)
        val switch1:SwitchMaterial = view.findViewById(R.id.switch1)
        // Obtener el ID del plato típico del argumento
        val platoId = arguments?.getInt(platosLocales.toString()) ?: 1

        // Buscar el objeto PlatoTipico de la lista local utilizando el ID
        val platoTipico = platosLocales.find { it.id == platoId }

        // Establecer los valores de las vistas con los datos del PlatoTipico

        nombreTextView.text = platoTipico?.nombre  // Utilizar el operador safe call (?) para evitar NullPointerException
        descripcionTextView.text = platoTipico?.descripcion
        Glide.with(requireContext()).load(platoTipico?.imagenUrl).into(imagenImageView)
        // Configurar el estado inicial del Switch
        switch1.isChecked = platoTipico?.checkCard ?: false

        // Agregar un listener al Switch para manejar los cambios en su estado
        switch1.setOnCheckedChangeListener { _, isChecked ->
            // Actualizar el estado del PlatoTipico con el estado del Switch
            platoTipico?.checkCard = isChecked
            // Realizar cualquier acción adicional según sea necesario
        }
        return view
    }


    companion object {
        @JvmStatic
        fun newInstance(): FoodCardFragment {
            return FoodCardFragment().apply {
                arguments = Bundle().apply {
                    putParcelableArrayList("platos", ArrayList(platosLocales))

                }
            }
        }
    }


}

