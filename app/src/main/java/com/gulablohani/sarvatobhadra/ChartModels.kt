package com.gulablohani.sarvatobhadra

data class BirthDetails(
    val date: String = "30/06/1983",
    val time: String = "01:19 AM",
    val place: String = "Jodhpur, Rajasthan, India",
    val latitude: Double = 26.2389,
    val longitude: Double = 73.0243,
    val timezone: String = "Asia/Kolkata"
)

data class ChartPlanet(
    val name: String,
    val longitude: Double,
    val sign: String,
    val nakshatra: String,
    val pada: Int,
    val speed: String,
    val retrograde: Boolean,
    val combust: Boolean
)

data class TransitSelection(
    val date: String = "16/10/2026",
    val time: String = "09:20 PM",
    val view: String = "Daily"
)

data class VedhaResult(
    val fromPlanet: String,
    val toPlanet: String,
    val nakshatraVedha: Boolean,
    val samePada: Boolean,
    val d1Aspect: Boolean,
    val vedhaType: String
)
