package com.zapir.ballmerpeak.domain.bacCalculator

class EbacCalculator(private val bodyWeight: Double,
                     private val isFemale: Boolean): BacCalculator {

    private val bloodWaterConst = 0.806
    private val convertFactor = 1.2
    private val bodyWater = if (isFemale) 0.49 else 0.58
    private val metabolismConst = if (isFemale) 0.017 else 0.015
    private val peakBeginning = 0.129
    private val peakEnding = 0.138

    override fun bacRate(drinks: Double, hours: Double): Double {
         return ((bloodWaterConst*drinks*convertFactor)/(bodyWater*bodyWeight) -
                 metabolismConst*hours)
    }

    override fun recommendDrinks(currentBacRate: Double): Double {
        val bacDeficit = peakEnding - currentBacRate
        return ((bacDeficit*bodyWeight*bodyWater)/(bloodWaterConst*convertFactor))
    }
}
