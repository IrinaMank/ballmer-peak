package com.zapir.ballmerpeak.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(val bodyWeight: Double,
                val isFemale: Boolean,
                val name: String
                ):Parcelable
