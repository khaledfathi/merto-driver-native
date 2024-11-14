package com.metro_driver.app.presentation.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.get
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.ViewModelProvider
import com.metro_driver.app.databinding.ActivityMainBinding
import com.metro_driver.app.presentation.viewmodel.MainActivityViewModel
import com.metro_driver.app.presentation.fragments.TravelsListFragment
import com.metro_driver.app.presentation.viewmodel.AddNewTravelActivityViewModel
import com.metro_driver.core.general.DATASTORE_FILE
import com.metro_driver.core.general.debugPrint

//prepare datastore
val Context.dataStore by preferencesDataStore(DATASTORE_FILE)

class MainActivity : BaseActivity() {
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

    /*##### Core #####*/

    private fun init() {
        setNightModeState()
        //events
        eventToolbarNightModeButtonClick()
        eventOnDateChange()
    }

    /**
     * read current night mode status ,then apply it to whole app UI
     */
    private fun setNightModeState() {
        _viewModel.setNightModeState(this)
        _binding.toolbar.menu[0].setIcon(_viewModel.themIcon)
    }
    /*##### -END- Core #####*/

    /*##### Events #####*/
    private fun eventToolbarNightModeButtonClick() {
        _binding.toolbar.menu[0].setOnMenuItemClickListener {
            _viewModel.toggleNightAndDayMode(this)
            true
        }
    }

    private fun eventOnDateChange() {
        _binding.datePicker.setOnDateChange { date ->
            debugPrint(date)
            supportFragmentManager.beginTransaction()
                .replace(_binding.travelsListFragmentContainer.id, TravelsListFragment()).commit()
        }
    }

    /*##### -END- Events #####*/
}
