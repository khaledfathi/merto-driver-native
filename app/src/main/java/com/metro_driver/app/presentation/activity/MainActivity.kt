package com.metro_driver.app.presentation.activity

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.metro_driver.app.data.repository.TravelRepositoryImp
import com.metro_driver.app.databinding.ActivityMainBinding
import com.metro_driver.app.domain.entity.TravelEntity
import com.metro_driver.app.domain.usecase.AddTravelUseCase
import com.metro_driver.app.presentation.viewmodel.MainActivityViewModel
import com.metro_driver.core.R
import com.metro_driver.core.general.DateTime
import com.metro_driver.core.general.Debug
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class MainActivity : AppCompatActivity() {
    private lateinit var _binding: ActivityMainBinding
    private lateinit var _viewModel: MainActivityViewModel
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
        Debug.print(
            resources.getText(R.string.month_1)
        )
        init()
    }

    private fun init() {
        _binding.todayButton.setOnClickListener {
            val data = TravelEntity(
                date = DateTime().getCurrentISODate(),
                time = DateTime().getCurrentISOTime(),
                travelNumber = 100,
                unitA = 14,
                unitB = 30,
                unitC = 55,
                notes = "notes aaa "
            )
            _viewModel.addTravel(
                context = this,
                travel = data,
                onSuccess = { recordId ->
                    Debug.print(recordId)
                },
                onFailure = { error ->
                    Debug.print(error)
                })
        }
    }
}