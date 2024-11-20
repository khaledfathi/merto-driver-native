package com.metro_driver.app.presentation.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.metro_driver.app.R
import com.metro_driver.app.databinding.CardTravelBinding
import com.metro_driver.app.domain.entity.TravelEntity
import com.metro_driver.app.presentation.fragments.HomeFragmentDirections

class TravelsAdapter(val context: Activity, val data: List<TravelEntity>) :
    RecyclerView.Adapter<TravelsAdapter.VH>() {
    class VH(val view: CardTravelBinding) : RecyclerView.ViewHolder(view.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val binding = CardTravelBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return VH(binding)
    }


    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.view.travelNumber.text = data[position].travelNumber?.toString() ?: "---"
        holder.view.unitA.text = data[position].unitA?.toString() ?: "---"
        holder.view.unitB.text = data[position].unitB?.toString() ?: "---"
        holder.view.unitC.text = data[position].unitC?.toString() ?: "---"
        if (data[position].notes?.isNotBlank() == true) {
            holder.view.note.setImageResource(R.drawable.warning_icon)
        }
        holder.view.root.setOnClickListener {
            //navigation
            val action = HomeFragmentDirections.actionHomeFragmentToEditTravelFragment(
                id = data[position].id!!,
                date = data[position].date,
                time = data[position].time,
                travelNumber = data[position].travelNumber?.toString() ?: "",
                unitA = data[position].unitA?.toString() ?: "",
                unitB = data[position].unitB?.toString() ?: "",
                unitC = data[position].unitC?.toString() ?: "",
                notes = data[position].notes ?: "",
            )
            holder.view.root.findNavController()
                .navigate(action)

        }
    }


}