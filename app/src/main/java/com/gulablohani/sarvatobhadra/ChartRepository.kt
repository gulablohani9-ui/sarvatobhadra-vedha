package com.gulablohani.sarvatobhadra

object ChartRepository {

    val defaultBirth = BirthDetails()

    val planets = listOf(
        ChartPlanet(
            "सूर्य", 105.20, "कर्क", "पुष्य", 2,
            "मार्गी", false, false
        ),
        ChartPlanet(
            "चंद्रमा", 312.40, "कुंभ", "धनिष्ठा", 2,
            "शीघ्र", false, false
        ),
        ChartPlanet(
            "मंगल", 70.10, "मिथुन", "पुनर्वसु", 3,
            "मार्गी", false, false
        ),
        ChartPlanet(
            "बुध", 120.80, "सिंह", "मघा", 1,
            "मार्गी", false, true
        ),
        ChartPlanet(
            "गुरु", 45.50, "वृषभ", "कृत्तिका", 4,
            "मार्गी", false, false
        ),
        ChartPlanet(
            "शुक्र", 155.30, "कन्या", "हस्त", 2,
            "शीघ्र", false, false
        ),
        ChartPlanet(
            "शनि", 330.60, "मीन", "रेवती", 1,
            "वक्री", true, false
        ),
        ChartPlanet(
            "राहु", 20.00, "मेष", "भरणी", 2,
            "वक्री", true, false
        ),
        ChartPlanet(
            "केतु", 200.00, "तुला", "विशाखा", 2,
            "वक्री", true, false
        )
    )
}
