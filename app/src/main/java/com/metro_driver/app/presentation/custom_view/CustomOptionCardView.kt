package com.metro_driver.app.presentation.custom_view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.metro_driver.app.R
import com.metro_driver.app.databinding.CustomOptionCardBinding

class CustomOptionCardView(context: Context, attr: AttributeSet) : FrameLayout(context, attr) {
    private val _binding = CustomOptionCardBinding.inflate(LayoutInflater.from(context))

    init {
        //get attribute
        context.obtainStyledAttributes(attr, R.styleable.CustomOptionCardView, 0, 0).apply {
            _binding.titleTextView.text =
                getString(R.styleable.CustomOptionCardView_title) ?: "Option Title"
            _binding.optionIconImageView.setImageResource(
                getResourceId(
                    R.styleable.CustomOptionCardView_icon,
                    R.drawable.train_icon
                )
            )
            _binding.titleTextView.setTextColor(
                getColor(
                    R.styleable.CustomOptionCardView_text_color,
                    0xff000000.toInt()
                )
            )
        }.recycle()

        addView(_binding.root)
    }
}