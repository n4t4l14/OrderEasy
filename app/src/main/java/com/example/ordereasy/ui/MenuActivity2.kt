package com.example.ordereasy

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.ordereasy.R.id
import com.example.ordereasy.databinding.ActivityMenu2Binding
import com.google.android.material.navigation.NavigationView
import com.google.android.material.snackbar.Snackbar


class MenuActivity2 : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMenu2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inflar el layout de la actividad utilizando ViewBinding
        binding = ActivityMenu2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // Configurar la barra de herramientas como la barra de acción de la actividad
        setSupportActionBar(binding.appBarMenu2.toolbar)

        // Configurar el listener del botón flotante
        binding.appBarMenu2.fab.setOnClickListener { view ->
            Snackbar.make(view, "Reemplaza con tu propia acción", Snackbar.LENGTH_LONG)
                .setAction("Acción", null)
                .setAnchorView(id.fab).show()
        }

        // Obtener referencias al DrawerLayout y NavigationView
        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView

        // Obtener el NavController y configurar AppBarConfiguration para la navegación
        val navController = findNavController(id.nav_host_fragment_content_menu2)
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_food_menu, R.id.nav_profile, R.id.nav_my_shopping
            ), drawerLayout
        )

        // Configurar ActionBar con NavController y AppBarConfiguration
        setupActionBarWithNavController(navController, appBarConfiguration)

        // Configurar NavigationView con NavController
        navView.setupWithNavController(navController)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflar el menú de opciones
        menuInflater.inflate(R.menu.menu_activity2, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        // Manejar el evento de navegación hacia arriba
        val navController = findNavController(id.nav_host_fragment_content_menu2)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    // Función para manejar el click en elementos del menú de opciones
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            id.action_shopping_cart -> {
                // Navegar al fragmento ShoppingCartFragment
                val navController = findNavController(id.nav_host_fragment_content_menu2)
                navController.navigate(id.nav_shopping_cart)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}