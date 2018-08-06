package com.zapir.ballmerpeak.domain.bacCalculator

interface BacCalculator {

    fun bacRate(drinks: Double, hours: Double): Double
    fun recommendDrinks(currentBacRate: Double): Double
}
