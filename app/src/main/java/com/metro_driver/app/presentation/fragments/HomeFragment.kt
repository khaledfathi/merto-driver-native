package com.metro_driver.app.presentation.fragments

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.metro_driver.app.R
import com.metro_driver.app.databinding.FragmentHomeBinding
import com.metro_driver.app.presentation.adapter.TravelsAdapter
import com.metro_driver.app.presentation.viewmodel.MainActivityViewModel

class HomeFragment : Fragment() {
    private lateinit var _binding: FragmentHomeBinding
    private lateinit var _viewModel: MainActivityViewModel
    private lateinit var _activity: FragmentActivity
    private lateinit var _context: Context


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        _viewModel = ViewModelProvider(requireActivity())[MainActivityViewModel::class.java]
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _activity = requireActivity()
        _context = requireContext()
        init()
    }


    /*##### Core #####*/
    private fun init() {
        // ---- pre
        getTravels()
        // ---- events
        eventOnDateChange()
        eventOnAddFloatingButtonClick()
        eventOnDateChange()
        // ---- observers
        observers()
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun observers() {
        //on travel list changes
        _viewModel.travelList.observe(viewLifecycleOwner) {
            _binding.travelsListRecycleView.adapter?.notifyDataSetChanged()
        }
    }

    private fun getTravels() {

        // ---- read and set travels list
        _viewModel.currentSelectedDate =
            _binding.datePicker.getCurrentSelectedDate().localDateObject;
        _viewModel.getTravelsByDate(
            context = _context,
            date = _viewModel.currentSelectedDate,
            onSuccess = { travelsList ->
                _binding.travelsListRecycleView.adapter = TravelsAdapter(_activity, travelsList)
                setEmptyTravelMessage(travelsList.isEmpty())
            },
            onFailure = {}
        )
    }

    /*##### Events #####*/
    private fun eventOnDateChange() {
        _binding.datePicker.setOnDateChange { date ->
            _viewModel.getTravelsByDate(
                context = _context,
                date = date.localDateObject,
                onSuccess = { travelsList ->
                    _binding.travelsListRecycleView.adapter = TravelsAdapter(_activity, travelsList)
                    setEmptyTravelMessage(travelsList.isEmpty())
                },
                onFailure = {}
            )
        }
    }

    private fun eventOnAddFloatingButtonClick() {
        _binding.addTravelFloatingButton.setOnClickListener {
            _binding.root.findNavController()
                .navigate(R.id.action_homeFragment_to_addTravelFragment)
        }
    }

    private fun setEmptyTravelMessage(isEmpty:Boolean) {
        _binding.nothingFoundTextView.isVisible = isEmpty
    }
}