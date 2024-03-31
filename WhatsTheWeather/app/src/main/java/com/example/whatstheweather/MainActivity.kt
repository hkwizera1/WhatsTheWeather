package com.example.whatstheweather
import android.os.Bundle
import android.view.Gravity
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.whatstheweather.R
import com.google.android.material.navigation.NavigationView

//import androidx.appcompat.app.AppCompatDelegate

class MainActivity : AppCompatActivity() {

    private var drawerLayout: DrawerLayout? = null
    private var actionBarDrawerToggle: ActionBarDrawerToggle? = null
    private var navigationView: NavigationView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, WeatherFragment())
                .commitNow()
        }

        drawerLayout = findViewById(R.id.drawer_layout)
        navigationView = findViewById(R.id.nav_view)

        // Initialize ActionBarDrawerToggle only if drawerLayout is not null
        drawerLayout?.let {
            actionBarDrawerToggle = ActionBarDrawerToggle(this, it, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
            it.addDrawerListener(actionBarDrawerToggle!!)
            actionBarDrawerToggle?.syncState()
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }

        navigationView?.setNavigationItemSelectedListener { menuItem ->
            // Handle navigation item clicks here.
            when (menuItem.itemId) {


                R.id.menu_metric -> {
                    // Set temperature unit to metric
                    Toast.makeText(this@MainActivity, "Metric selected", Toast.LENGTH_SHORT).show()
                    // Implement your logic here
                    true
                }
                R.id.menu_imperial -> {
                    // Set temperature unit to imperial
                    Toast.makeText(this@MainActivity, "Imperial selected", Toast.LENGTH_SHORT).show()
                    // Implement your logic here
                    true
                }
                else -> false
            }
        }
        // Inflate the menu to show toggle button for light/dark mode
        onCreateOptionsMenu(null)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here.
        return when (item.itemId) {
            android.R.id.home -> {
                drawerLayout?.let {
                    if (it.isDrawerOpen(GravityCompat.START)) {
                        it.closeDrawer(GravityCompat.START)
                    } else {
                        it.openDrawer(GravityCompat.START)
                    }
                }
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
    /*override fun onCreateOptionsMenu(menu: android.view.Menu?): Boolean {
        menuInflater.inflate(R.menu.navigation_menu, menu)

        // Find the toggle menu item and set its state based on current app theme
        val toggleMenuItem = menu?.findItem(R.id.menu_light_dark_toggle)
        val switchView = toggleMenuItem?.actionView as androidx.appcompat.widget.SwitchCompat

        // Set switch state based on current app theme
        switchView.isChecked = AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES

        // Listen for switch changes
        switchView.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                // Switch to dark mode
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            } else {
                // Switch to light mode
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
        }

        return true
    }*/



    override fun onBackPressed() {
        if (drawerLayout?.isDrawerOpen(GravityCompat.START) == true) {
            drawerLayout?.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
}




/*class MainActivity : AppCompatActivity() {

    private var drawerLayout: DrawerLayout? = null
    private var actionBarDrawerToggle: ActionBarDrawerToggle? = null
    private var navigationView: NavigationView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, WeatherFragment())
                .commitNow()
        }

        drawerLayout = findViewById(R.id.drawer_layout)
        navigationView = findViewById(R.id.nav_view)

        // Initialize ActionBarDrawerToggle only if drawerLayout is not null
        drawerLayout?.let {
            actionBarDrawerToggle = ActionBarDrawerToggle(this, it, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
            it.addDrawerListener(actionBarDrawerToggle!!)
            actionBarDrawerToggle?.syncState()
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }

        navigationView?.setNavigationItemSelectedListener { menuItem ->
            // Handle navigation item clicks here.
            when (menuItem.itemId) {
                R.id.menu_metric -> {
                    // Set temperature unit to metric
                    Toast.makeText(this@MainActivity, "Metric selected", Toast.LENGTH_SHORT).show()
                    // Implement your logic here
                    true
                }
                R.id.menu_imperial -> {
                    // Set temperature unit to imperial
                    Toast.makeText(this@MainActivity, "Imperial selected", Toast.LENGTH_SHORT).show()
                    // Implement your logic here
                    true
                }
                else -> false
            }
        }

        // Inflate the menu to show toggle button for light/dark mode
        onCreateOptionsMenu(null)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here.
        return when (item.itemId) {
            android.R.id.home -> {
                drawerLayout?.let {
                    if (it.isDrawerOpen(GravityCompat.START)) {
                        it.closeDrawer(GravityCompat.START)
                    } else {
                        it.openDrawer(GravityCompat.START)
                    }
                }
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onCreateOptionsMenu(menu: android.view.Menu?): Boolean {
        menuInflater.inflate(R.menu.navigation_menu, menu)

        // Find the toggle menu item and set its state based on current app theme
        val toggleMenuItem = menu?.findItem(R.id.menu_light_dark_toggle)
        val switchView = toggleMenuItem?.actionView as androidx.appcompat.widget.SwitchCompat

        // Set switch state based on current app theme
        switchView.isChecked = AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES

        // Listen for switch changes
        switchView.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                // Switch to dark mode
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            } else {
                // Switch to light mode
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
        }

        return true
    }

    override fun onBackPressed() {
        if (drawerLayout?.isDrawerOpen(GravityCompat.START) == true) {
            drawerLayout?.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
}*/
