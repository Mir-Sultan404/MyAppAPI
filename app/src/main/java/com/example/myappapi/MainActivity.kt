package com.example.myappapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomView = findViewById<BottomNavigationView>(R.id.bottom_nav)
        val navController = findNavController(R.id.container)

        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            if (destination.id == R.id.createNoteFragment) {
                bottomView.visibility = View.GONE
            } else bottomView.visibility = View.VISIBLE
        }

        bottomView.setupWithNavController(navController)
    }
}