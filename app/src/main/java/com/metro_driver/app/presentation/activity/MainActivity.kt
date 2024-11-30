package com.metro_driver.app.presentation.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.children
import androidx.core.view.get
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavHostController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.metro_driver.app.R
import com.metro_driver.app.databinding.ActivityMainBinding
import com.metro_driver.app.presentation.fragments.HomeFragment
import com.metro_driver.app.presentation.viewmodel.MainActivityViewModel
import com.metro_driver.core.general.DATASTORE_FILE
import com.metro_driver.core.general.debugPrint

//prepare datastore
val Context.dataStore by preferencesDataStore(DATASTORE_FILE)

class MainActivity : BaseActivity() {
    //toolbar option
    private val THEME_MODE_OPTION = 0

    //drawer options index
    private val TRAVELS_OPTION = 0
    private val VACATION_OPTION = 1
    private val ABOUT_OPTION = 2

    //
    private lateinit var _binding: ActivityMainBinding
    private lateinit var _viewModel: MainActivityViewModel

    //
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        _binding = ActivityMainBinding.inflate(layoutInflater)
        _viewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]
        setContentView(_binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(_binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        init()
    }

    /*##### CORE #####*/
    private fun init() {
        setNightModeState()
        setEvents()
    }

    private fun setEvents() {
        eventToolbarNightModeButtonClick()
        eventOpenDrawer()
        eventOnMenuTravelsClick()
        eventOnMenuVacationClick()
        eventOnMenuAboutClick()
    }

    /**
     * read current night mode status ,then apply it to whole app UI
     */
    private fun setNightModeState() {
        _viewModel.setNightModeState(this)
        _binding.toolbar.menu[THEME_MODE_OPTION].setIcon(_viewModel.getThemeIcon())
    }


    /*##### Events #####*/
    private fun eventToolbarNightModeButtonClick() {
        _binding.toolbar.menu[0].setOnMenuItemClickListener {
            _viewModel.toggleNightAndDayMode(this)
            true
        }
    }

    private fun eventOpenDrawer() {
        _binding.toolbar.setNavigationOnClickListener {
            _binding.drawerLayout.open();
        }
    }

    private fun eventOnMenuTravelsClick() {
        _binding.draweNavigation.menu[TRAVELS_OPTION].setOnMenuItemClickListener {
            actionCloseDrawer()
            startActivity(Intent(this, YearlyTravelsActivity::class.java))
            true
        }
    }

    private fun eventOnMenuVacationClick() {
        _binding.draweNavigation.menu[VACATION_OPTION].setOnMenuItemClickListener {
            actionCloseDrawer()
            startActivity(Intent(this, VacationsActivity::class.java))
            true
        }
    }

    private fun eventOnMenuAboutClick() {
        actionCloseDrawer()
        _binding.draweNavigation.menu[ABOUT_OPTION].setOnMenuItemClickListener {
            actionCloseDrawer()
            true
        }
    }

    /*##### Actions #####*/
    private fun actionCloseDrawer() {
        _binding.drawerLayout.close();
    }

}