package com.zapir.ballmerpeak.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
data class Drink(val drinks: Double,
                 val date: Date = Date()): Parcelable