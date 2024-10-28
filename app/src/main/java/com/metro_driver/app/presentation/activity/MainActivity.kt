package com.metro_driver.app.presentation.activity

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.metro_driver.app.data.repository.TravelRepositoryImp
import com.metro_driver.app.databinding.ActivityMainBinding
import com.metro_driver.app.domain.entity.TravelEntity

class MainActivity : AppCompatActivity() {
    private lateinit var _binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(_binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(_binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        init()
    }

    private fun init(){
        _binding.todayButton.setOnClickListener {
            val record = TravelRepositoryImp(this).insert(
                TravelEntity(
                    date = "10/10/2020",
                    time ="10:10",
                    travelNumber = 4387,
                    unitA =  8534,
                    unitB =  9438,
                    unitC =  444,
                    notes = "fjkdsh"
                )
            )

            Log.d("debug" , record.toString())
        }
    }
}