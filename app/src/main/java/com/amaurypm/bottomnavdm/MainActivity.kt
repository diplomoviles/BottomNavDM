package com.amaurypm.bottomnavdm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController

import com.amaurypm.bottomnavdm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.navView.background = null //si ponemos o quitamos esto se usa el gradiente o no. No se puede tener el gradiente con el  efecto craddle. Si quieremos el craddle tenemos que usar un color sólido (el que está en el stylo del BotttomAppBar)

        binding.navView.menu.getItem(2).isEnabled = false //deshabilitando el item que pusimos como espacio

        val navController = findNavController(R.id.nav_host_fragment_container)

        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home,
                R.id.navigation_favorites,
                R.id.navigation_notifications,
                R.id.navigation_inbox
            )
        )

        setupActionBarWithNavController(navController, appBarConfiguration)

        binding.navView.setupWithNavController(navController)

    }
}