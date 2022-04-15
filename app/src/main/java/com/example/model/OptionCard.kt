package com.example.model

import android.text.format.Time
import java.util.Date

data class OptionCard(
    val from: String,
    val to: String,
    val time: String,
    val date: String,
    val seats: String,
    val seatsAvailable: Int,
)
