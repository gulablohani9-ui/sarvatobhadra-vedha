package com.gulablohani.sarvatobhadra

object VedhaCalculator {

    fun sameNakshatra(
        first: ChartPlanet,
        second: ChartPlanet
    ): Boolean {
        return first.nakshatra == second.nakshatra
    }

    fun samePada(
        first: ChartPlanet,
        second: ChartPlanet
    ): Boolean {
        return first.nakshatra == second.nakshatra &&
            first.pada == second.pada
    }

    fun seventhAspect(
        first: ChartPlanet,
        second: ChartPlanet
    ): Boolean {
        val distance =
            (second.longitude - first.longitude + 360.0) % 360.0

        return distance in 165.0..195.0
    }

    fun vedhaType(planet: ChartPlanet): String {
        return when {
            planet.name == "सूर्य" -> "तीनों वेध"
            planet.name == "चंद्रमा" -> "तीनों वेध"
            planet.name == "राहु" -> "तीनों वेध"
            planet.name == "केतु" -> "तीनों वेध"
            planet.retrograde -> "दायाँ वेध"
            planet.speed == "शीघ्र" -> "बायाँ वेध"
            else -> "सन्मुख वेध"
        }
    }

    fun result(
        first: ChartPlanet,
        second: ChartPlanet
    ): VedhaResult {
        return VedhaResult(
            fromPlanet = first.name,
            toPlanet = second.name,
            nakshatraVedha = sameNakshatra(first, second),
            samePada = samePada(first, second),
            d1Aspect = seventhAspect(first, second),
            vedhaType = vedhaType(first)
        )
    }

    fun search(query: String): List<ChartPlanet> {
        if (query.isBlank()) {
            return ChartRepository.planets
        }

        return ChartRepository.planets.filter { planet ->
            planet.name.contains(query, true) ||
                planet.sign.contains(query, true) ||
                planet.nakshatra.contains(query, true) ||
                planet.speed.contains(query, true)
        }
    }
}
