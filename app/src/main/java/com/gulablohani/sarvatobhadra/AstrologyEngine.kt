package com.gulablohani.sarvatobhadra

data class PlanetPosition(
    val name: String,
    val longitude: Double,
    val sign: String,
    val nakshatra: String,
    val pada: Int,
    val motion: String,
    val retrograde: Boolean,
    val combust: Boolean
)

object AstrologyEngine {

    private val nakshatras = listOf(
        "अश्विनी", "भरणी", "कृत्तिका", "रोहिणी",
        "मृगशीर्ष", "आर्द्रा", "पुनर्वसु", "पुष्य",
        "आश्लेषा", "मघा", "पूर्वाफाल्गुनी", "उत्तराफाल्गुनी",
        "हस्त", "चित्रा", "स्वाती", "विशाखा",
        "अनुराधा", "ज्येष्ठा", "मूल", "पूर्वाषाढ़ा",
        "उत्तराषाढ़ा", "श्रवण", "धनिष्ठा", "शततारका",
        "पूर्वाभाद्रपदा", "उत्तराभाद्रपदा", "रेवती"
    )

    private val signs = listOf(
        "मेष", "वृषभ", "मिथुन", "कर्क",
        "सिंह", "कन्या", "तुला", "वृश्चिक",
        "धनु", "मकर", "कुंभ", "मीन"
    )

    fun demoPositions(): List<PlanetPosition> {
        return listOf(
            PlanetPosition(
                name = "सूर्य",
                longitude = 105.20,
                sign = "कर्क",
                nakshatra = "पुष्य",
                pada = 2,
                motion = "मार्गी",
                retrograde = false,
                combust = false
            ),
            PlanetPosition(
                name = "चंद्रमा",
                longitude = 312.40,
                sign = "कुंभ",
                nakshatra = "धनिष्ठा",
                pada = 2,
                motion = "शीघ्र",
                retrograde = false,
                combust = false
            ),
            PlanetPosition(
                name = "मंगल",
                longitude = 70.10,
                sign = "मिथुन",
                nakshatra = "पुनर्वसु",
                pada = 3,
                motion = "मार्गी",
                retrograde = false,
                combust = false
            ),
            PlanetPosition(
                name = "बुध",
                longitude = 120.80,
                sign = "सिंह",
                nakshatra = "मघा",
                pada = 1,
                motion = "मार्गी",
                retrograde = false,
                combust = true
            ),
            PlanetPosition(
                name = "गुरु",
                longitude = 45.50,
                sign = "वृषभ",
                nakshatra = "कृत्तिका",
                pada = 4,
                motion = "मार्गी",
                retrograde = false,
                combust = false
            ),
            PlanetPosition(
                name = "शुक्र",
                longitude = 155.30,
                sign = "कन्या",
                nakshatra = "हस्त",
                pada = 2,
                motion = "शीघ्र",
                retrograde = false,
                combust = false
            ),
            PlanetPosition(
                name = "शनि",
                longitude = 330.60,
                sign = "मीन",
                nakshatra = "रेवती",
                pada = 1,
                motion = "वक्री",
                retrograde = true,
                combust = false
            ),
            PlanetPosition(
                name = "राहु",
                longitude = 20.00,
                sign = "मेष",
                nakshatra = "भरणी",
                pada = 2,
                motion = "वक्री",
                retrograde = true,
                combust = false
            ),
            PlanetPosition(
                name = "केतु",
                longitude = 200.00,
                sign = "तुला",
                nakshatra = "विशाखा",
                pada = 2,
                motion = "वक्री",
                retrograde = true,
                combust = false
            )
        )
    }

    fun sameNakshatra(
        first: PlanetPosition,
        second: PlanetPosition
    ): Boolean {
        return first.nakshatra == second.nakshatra
    }

    fun samePada(
        first: PlanetPosition,
        second: PlanetPosition
    ): Boolean {
        return first.nakshatra == second.nakshatra &&
            first.pada == second.pada
    }

    fun seventhAspect(
        first: PlanetPosition,
        second: PlanetPosition
    ): Boolean {
        val distance = ((second.longitude - first.longitude + 360.0) % 360.0)
        return distance in 165.0..195.0
    }

    fun planetResult(
        first: PlanetPosition,
        second: PlanetPosition
    ): String {
        val sameNakshatra = sameNakshatra(first, second)
        val samePada = samePada(first, second)
        val aspect = seventhAspect(first, second)

        return """
            ${first.name} → ${second.name}
            नक्षत्र वेध: ${if (sameNakshatra) "YES" else "NO"}
            एक ही पद: ${if (samePada) "YES" else "NO"}
            D1/7वीं दृष्टि: ${if (aspect) "YES" else "NO"}
        """.trimIndent()
    }

    fun search(query: String): List<PlanetPosition> {
        if (query.isBlank()) return demoPositions()

        return demoPositions().filter {
            it.name.contains(query, ignoreCase = true) ||
                it.sign.contains(query, ignoreCase = true) ||
                it.nakshatra.contains(query, ignoreCase = true) ||
                it.motion.contains(query, ignoreCase = true)
        }
    }
}
