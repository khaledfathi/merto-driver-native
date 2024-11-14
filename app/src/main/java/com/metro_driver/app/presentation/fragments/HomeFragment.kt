package com.metro_driver.app.presentation.fragments

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.metro_driver.app.R
import com.metro_driver.app.databinding.FragmentHomeBinding
import com.metro_driver.app.domain.entity.TravelEntity
import com.metro_driver.app.presentation.adapter.TravelsAdapter

class HomeFragment : Fragment() {
    private lateinit var _binding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    /*##### Core #####*/
    private fun init() {
        eventOnDateChange()
        eventOnAddFloatingButtonClick()
        val data = mutableListOf<TravelEntity>()
        val date= _binding.datePicker.getCurrentSelectedDate()
        data.clear()
        for (i in 1..10) {
            data.add(
                TravelEntity(
                    travelNumber = "${100 + date.day}".toInt(),
                    unitA = "${100 + i + date.day}".toInt(),
                    unitB = "${43 + i + date.day}".toInt(),
                    unitC = "${56 + i + date.day}".toInt()
                )
            )
        }
        _binding.travelsListRecycleView.adapter = TravelsAdapter(requireContext() as Activity, data)
    }

    /*##### Events #####*/
    private fun eventOnDateChange() {
        val data = mutableListOf<TravelEntity>()
        _binding.datePicker.setOnDateChange { date ->
            data.clear()
            for (i in 1..10) {
                data.add(
                    TravelEntity(
                        travelNumber = "${100 + date.day}".toInt(),
                        unitA = "${100 + i + date.day}".toInt(),
                        unitB = "${43 + i + date.day}".toInt(),
                        unitC = "${56 + i + date.day}".toInt()
                    )
                )
            }
            _binding.travelsListRecycleView.adapter =
                TravelsAdapter(requireContext() as Activity, data)
        }
    }

    private fun eventOnAddFloatingButtonClick() {
        _binding.addTravelFloatingButton.setOnClickListener {
            _binding.root.findNavController()
                .navigate(R.id.action_homeFragment_to_addTravelFragment)
        }
    }
}