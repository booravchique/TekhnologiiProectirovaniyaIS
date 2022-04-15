package com.example.bus.ui.layot

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bus.repository.CitiesRepository
import com.example.bus.repository.OptionCardRepository
import com.example.bus.ui.theme.CardYellow
import com.example.bus.ОptionsBar
import com.example.model.Cities

@Preview
@Composable
fun ScheludeScreen() {
    Box(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize()
            .padding(start = 12.dp, end = 12.dp)
    ) {
        Text(
            text = "Расписание",
            style = MaterialTheme.typography.h5,
            modifier = Modifier.padding(top = 25.dp),
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 60.dp)
        ) {
            ScheludeFinder()
            Content()

        }
    }
}

@Composable
fun ScheludeFinder() {
    val shape = RoundedCornerShape(5.dp)
    var searchValue by remember { mutableStateOf(TextFieldValue(text = "")) }

    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column() {
            BasicTextField(
                value = searchValue,
                onValueChange = { searchValue = it },
                modifier = Modifier
                    .height(70.dp)
                    .clip(shape)
                    .padding(top = 10.dp, bottom = 10.dp)
                    .border(
                        BorderStroke(1.dp, color = Color.Black), shape = shape
                    )
                    .width(160.dp),
                singleLine = true,
                decorationBox = { innerTextField ->
                    Row(
                        Modifier
                            .padding(start = 10.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        if (searchValue.text.isEmpty()) {
                            Text("Откуда", style = MaterialTheme.typography.h5)
                        }
                        innerTextField()
                    }
                }
            )
        }
        Box() {
            Column(
                modifier = Modifier.clickable {}
            ) {
                Icon(
                    Icons.Default.ArrowForward,
                    contentDescription = ""
                )
                Icon(
                    Icons.Default.ArrowBack,
                    contentDescription = ""
                )
            }

        }
        Column() {
            BasicTextField(
                value = searchValue,
                onValueChange = { searchValue = it },
                modifier = Modifier
                    .height(70.dp)
                    .clip(shape)
                    .padding(top = 10.dp, bottom = 10.dp)
                    .border(
                        BorderStroke(1.dp, color = Color.Black), shape = shape
                    )
                    .width(160.dp),
                singleLine = true,
                decorationBox = { innerTextField ->
                    Row(
                        Modifier
                            .padding(start = 10.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        if (searchValue.text.isEmpty()) {
                            Text("Куда", style = MaterialTheme.typography.h5)
                        }
                        innerTextField()
                    }
                }
            )
        }
    }
}

@Composable
fun Content() {
    Column() {
        Text(
            modifier = Modifier.padding(bottom = 10.dp),
            text = "Маршрут",
            style = MaterialTheme.typography.body1,
            fontWeight = FontWeight.Bold,
        )
        SingleCityData()
    }
}


@Composable
fun Route(
    name: List<String>
) {
    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        items(name.size) {
            Column(
                horizontalAlignment = Alignment.Start,
            ) {
                Box() {
                    Text(
                        text = name[it],
                        style = MaterialTheme.typography.body1
                    )
                    SingleCityData()
                }

            }

        }
    }
}

@Composable
fun SingleCityData() {
    val citiesRepository = CitiesRepository()
    val getAllCitiesData = citiesRepository.getAllCitiesData()

    Row() {
        LazyColumn(
            modifier = Modifier.padding(bottom = 50.dp)
        ) {
            items(items = getAllCitiesData) { singleCity ->
                SingleCity(cities = singleCity)
            }
        }
    }


}

@Composable
fun SingleCity(
    cities: Cities
) {
    Card(
        modifier = Modifier.padding(bottom = 14.dp),
        elevation = 4.dp,
    ) {
        Column(
            modifier = Modifier
                .background(CardYellow)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = cities.city,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 8.dp, bottom = 8.dp),
                style = MaterialTheme.typography.h5,
            )
            Text(
                cities.schelude,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 8.dp, bottom = 8.dp),
                style = MaterialTheme.typography.h6,
            )
            Text(
                cities.time,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 8.dp, bottom = 8.dp),
                style = MaterialTheme.typography.body1,
            )
        }
    }
}
