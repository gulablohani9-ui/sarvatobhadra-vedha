package com.gulablohani.sarvatobhadra

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme {
                SarvatobhadraApp()
            }
        }
    }
}

@Composable
fun SarvatobhadraApp() {
    var selectedTab by remember { mutableIntStateOf(0) }

    val tabs = listOf(
        "Home",
        "D1",
        "Transit",
        "Vedha",
        "Search"
    )

    Scaffold(
        bottomBar = {
            NavigationBar {
                tabs.forEachIndexed { index, title ->
                    NavigationBarItem(
                        selected = selectedTab == index,
                        onClick = { selectedTab = index },
                        icon = {},
                        label = { Text(title) }
                    )
                }
            }
        }
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
                .verticalScroll(rememberScrollState())
        ) {
            when (selectedTab) {
                0 -> HomeScreen()
                1 -> D1Screen()
                2 -> TransitScreen()
                3 -> VedhaScreen()
                4 -> SearchScreen()
            }
        }
    }
}

@Composable
fun HomeScreen() {
    Column {
        Text(
            text = "सर्वतोभद्र वेध ज्ञान",
            style = MaterialTheme.typography.headlineSmall
        )

        Spacer(modifier = Modifier.height(16.dp))

        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text("Default Birth Details")
                Spacer(modifier = Modifier.height(8.dp))
                Text("DOB: 30/06/1983")
                Text("Time: 01:19 AM")
                Text("Place: Jodhpur, Rajasthan, India")
                Text("Chart: Vedic Sidereal")
                Text("Ayanamsha: Lahiri")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text("इस app में D1, Transit, Vedha और Search sections हैं।")
        Text("Real astrology calculation अगले version में जोड़ी जाएगी।")
    }
}

@Composable
fun D1Screen() {
    Column {
        Text(
            text = "D1 Birth Chart",
            style = MaterialTheme.typography.headlineSmall
        )

        Spacer(modifier = Modifier.height(16.dp))

        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text("जन्म-कुंडली विवरण")
                Spacer(modifier = Modifier.height(8.dp))
                Text("जन्म तारीख: 30/06/1983")
                Text("जन्म समय: 01:19 AM")
                Text("जन्म स्थान: Jodhpur, Rajasthan")
                Text("D1 chart: तैयार")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text("लग्न: calculation pending")
        Text("सूर्य: calculation pending")
        Text("चंद्रमा: calculation pending")
        Text("ग्रह दृष्टि: calculation pending")
    }
}

@Composable
fun TransitScreen() {
    var selectedView by remember { mutableStateOf("Daily") }
    var dayOffset by remember { mutableIntStateOf(0) }
    var hourOffset by remember { mutableIntStateOf(0) }
    var minuteOffset by remember { mutableIntStateOf(0) }

    Column {
        Text(
            text = "Transit Chart",
            style = MaterialTheme.typography.headlineSmall
        )

        Spacer(modifier = Modifier.height(16.dp))

        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text("Transit Date: 16/10/2026")
                Text("Transit Time: 09:20 PM")
                Text("Place: Jodhpur, Rajasthan")
                Text("Day change: $dayOffset")
                Text("Hour change: $hourOffset")
                Text("Minute change: $minuteOffset")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text("समय बदलें")

        Spacer(modifier = Modifier.height(8.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState()),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Button(onClick = { dayOffset-- }) {
                Text("- Day")
            }

            Button(onClick = { hourOffset-- }) {
                Text("- Hour")
            }

            Button(onClick = { minuteOffset-- }) {
                Text("- Minute")
            }

            Button(onClick = {
                dayOffset = 0
                hourOffset = 0
                minuteOffset = 0
            }) {
                Text("Today")
            }

            Button(onClick = { minuteOffset++ }) {
                Text("+ Minute")
            }

            Button(onClick = { hourOffset++ }) {
                Text("+ Hour")
            }

            Button(onClick = { dayOffset++ }) {
                Text("+ Day")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text("Transit view")

        Spacer(modifier = Modifier.height(8.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState()),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Button(onClick = { selectedView = "Daily" }) {
                Text("Daily")
            }

            Button(onClick = { selectedView = "Weekly" }) {
                Text("Weekly")
            }

            Button(onClick = { selectedView = "Monthly" }) {
                Text("Monthly")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text("Selected: $selectedView")
        Text("Transit ग्रह data calculation pending है।")
    }
}

@Composable
fun VedhaScreen() {
    var selectedSection by remember { mutableStateOf("Vedha") }

    val sections = listOf(
        "Vedha",
        "Drishti",
        "Same Pad",
        "Search"
    )

    Column {
        Text(
            text = "Vedha & Drishti",
            style = MaterialTheme.typography.headlineSmall
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text("नीचे horizontal buttons में section चुनें:")

        Spacer(modifier = Modifier.height(8.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState()),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            sections.forEach { section ->
                Button(
                    onClick = {
                        selectedSection = section
                    }
                ) {
                    Text(section)
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        when (selectedSection) {
            "Vedha" -> VedhaSection()
            "Drishti" -> DrishtiSection()
            "Same Pad" -> SamePadSection()
            "Search" -> VedhaSearchSection()
        }
    }
}

@Composable
fun VedhaSection() {
    Card(
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                "ग्रहों का वेध",
                style = MaterialTheme.typography.titleLarge
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text("ग्रह 1: चंद्रमा")
            Text("ग्रह 2: शनि")
            Text("चंद्रमा किस नक्षत्र पर वेध कर रहा है: Pending")
            Text("नक्षत्र वेध: NO")
            Text("बायाँ वेध: NO")
            Text("सन्मुख वेध: NO")
            Text("दायाँ वेध: NO")
        }
    }
}

@Composable
fun DrishtiSection() {
    Card(
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                "D1 दृष्टि",
                style = MaterialTheme.typography.titleLarge
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text("दृष्टि डालने वाला ग्रह: गुरु")
            Text("दृष्टि पाने वाला ग्रह: चंद्रमा")
            Text("दृष्टि प्रकार: 5वीं")
            Text("D1 में दृष्टि: NO")
            Text("Transit में दृष्टि: NO")
        }
    }
}

@Composable
fun SamePadSection() {
    Card(
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                "Same Nakshatra / Same Pada",
                style = MaterialTheme.typography.titleLarge
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text("ग्रह 1: चंद्रमा")
            Text("ग्रह 2: शनि")
            Text("एक ही नक्षत्र: NO")
            Text("एक ही पद: NO")
        }
    }
}

@Composable
fun VedhaSearchSection() {
    var query by remember { mutableStateOf("") }

    Card(
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                "Vedha Search",
                style = MaterialTheme.typography.titleLarge
            )

            Spacer(modifier = Modifier.height(12.dp))

            OutlinedTextField(
                value = query,
                onValueChange = { query = it },
                modifier = Modifier.fillMaxWidth(),
                label = {
                    Text("ग्रह या नक्षत्र खोजें")
                },
                singleLine = true
            )

            Spacer(modifier = Modifier.height(12.dp))

            Button(onClick = {}) {
                Text("Search")
            }

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                if (query.isBlank()) {
                    "किसी ग्रह या नक्षत्र का नाम लिखें।"
                } else {
                    "Search result: $query"
                }
            )
        }
    }
}

@Composable
fun SearchScreen() {
    var query by remember { mutableStateOf("") }

    Column {
        Text(
            text = "Search",
            style = MaterialTheme.typography.headlineSmall
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = query,
            onValueChange = { query = it },
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text("ग्रह, नक्षत्र या राशि")
            },
            singleLine = true
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {}) {
            Text("Search")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            if (query.isBlank()) {
                "ग्रह, नक्षत्र या राशि लिखें।"
            } else {
                "Search result: $query"
            }
        )
    }
}
