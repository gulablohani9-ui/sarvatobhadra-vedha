package com.gulablohani.sarvatobhadra

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
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
    var tab by remember { mutableIntStateOf(0) }
    val tabs = listOf("Home", "D1", "Transit", "Vedha", "Search")

    Scaffold(
        bottomBar = {
            NavigationBar {
                tabs.forEachIndexed { index, title ->
                    NavigationBarItem(
                        selected = tab == index,
                        onClick = { tab = index },
                        icon = {},
                        label = { Text(title) }
                    )
                }
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp)
                .verticalScroll(rememberScrollState())
        ) {
            when (tab) {
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
        Text("सर्वतोभद्र वेध ज्ञान", style = MaterialTheme.typography.headlineSmall)
        Spacer(Modifier.height(16.dp))

        Card(Modifier.fillMaxWidth()) {
            Column(Modifier.padding(16.dp)) {
                Text("Default Birth Details")
                Text("DOB: 30/06/1983")
                Text("Time: 01:19 AM")
                Text("Place: Jodhpur, Rajasthan, India")
                Text("Chart: Vedic Sidereal")
                Text("Ayanamsha: Lahiri")
            }
        }

        Spacer(Modifier.height(16.dp))
        Text("Daily, Weekly, Monthly, D1, Transit और Search उपलब्ध हैं।")
    }
}

@Composable
fun D1Screen() {
    Column {
        Text("D1 Birth Chart", style = MaterialTheme.typography.headlineSmall)
        Spacer(Modifier.height(16.dp))
        Text("Birth date: 30/06/1983")
        Text("Birth time: 01:19 AM")
        Text("Birth place: Jodhpur, Rajasthan")
        Spacer(Modifier.height(16.dp))
        Text("Real planetary calculation बाद में जोड़ी जाएगी।")
    }
}

@Composable
fun TransitScreen() {
    var view by remember { mutableStateOf("Daily") }

    Column {
        Text("Transit Chart", style = MaterialTheme.typography.headlineSmall)
        Spacer(Modifier.height(16.dp))
        Text("Date: 16/10/2026")
        Text("Time: 09:20 PM")
        Text("Place: Jodhpur, Rajasthan")

        Spacer(Modifier.height(16.dp))

        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            Button(onClick = {}) { Text("- Day") }
            Button(onClick = {}) { Text("Today") }
            Button(onClick = {}) { Text("+ Day") }
        }

        Spacer(Modifier.height(16.dp))

        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            Button(onClick = { view = "Daily" }) { Text("Daily") }
            Button(onClick = { view = "Weekly" }) { Text("Weekly") }
            Button(onClick = { view = "Monthly" }) { Text("Monthly") }
        }

        Spacer(Modifier.height(16.dp))
        Text("Selected view: $view")
        Text("Transit calculation अभी pending है।")
    }
}

@Composable
fun VedhaScreen() {
    Column {
        Text("Vedha & Drishti", style = MaterialTheme.typography.headlineSmall)
        Spacer(Modifier.height(16.dp))

        Card(Modifier.fillMaxWidth()) {
            Column(Modifier.padding(16.dp)) {
                Text("चंद्रमा → शनि")
                Text("नक्षत्र वेध: NO")
                Text("एक ही नक्षत्र: NO")
                Text("एक ही पद: NO")
                Text("D1 दृष्टि: NO")
            }
        }
    }
}

@Composable
fun SearchScreen() {
    var query by remember { mutableStateOf("") }

    Column {
        Text("Search", style = MaterialTheme.typography.headlineSmall)
        Spacer(Modifier.height(16.dp))

        OutlinedTextField(
            value = query,
            onValueChange = { query = it },
            modifier = Modifier.fillMaxWidth(),
            label = { Text("ग्रह, नक्षत्र या राशि") },
            singleLine = true
        )

        Spacer(Modifier.height(16.dp))

        Button(onClick = {}) {
            Text("Search")
        }

        Spacer(Modifier.height(16.dp))

        Text(
            if (query.isBlank()) {
                "ग्रह, नक्षत्र या राशि लिखें।"
            } else {
                "Search: $query"
            }
        )
    }
}
