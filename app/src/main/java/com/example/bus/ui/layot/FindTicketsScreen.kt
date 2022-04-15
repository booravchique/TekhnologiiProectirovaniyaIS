package com.example.bus

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
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
import com.example.bus.repository.OptionCardRepository
import com.example.bus.ui.theme.ButtonColor
import com.example.model.OptionCard
import com.example.bus.ui.theme.CardYellow
import com.example.bus.ui.theme.FilterGreen
import com.example.bus.ui.theme.selectedFilterGreen


@Preview
@Composable
fun FindTicketsScreen() {
    Box(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize()
            .padding(start = 12.dp, end = 12.dp)
    ) {
        Text(
            text = "Найти билеты",
            style = MaterialTheme.typography.h5,
            modifier = Modifier.padding(top = 25.dp),
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 60.dp)
        ) {
            TicketFinder()
            Filters(name = listOf("Дата", "Время", "Тип транспорта"))
            Options()
        }
    }
}

@Composable
fun TicketFinder() {
    val shape = RoundedCornerShape(5.dp)
    var searchValue by remember { mutableStateOf(TextFieldValue(text = "")) }
    Column() {
        BasicTextField(
            value = searchValue,
            onValueChange = { searchValue = it },
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp)
                .clip(shape)
                .padding(top = 10.dp, bottom = 10.dp)
                .border(
                    BorderStroke(1.dp, color = Color.Black), shape = shape
                ),
            singleLine = true,
            decorationBox = { innerTextField ->
                Row(
                    Modifier
                        .padding(start = 10.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    if (searchValue.text.isEmpty()) {
                        Text("Поиск", style = MaterialTheme.typography.h5)
                    }
                    innerTextField()
                }
            }
        )
    }
}

@Composable
fun Filters(
    name: List<String>
) {
    var selectedItemIndex by remember {
        mutableStateOf(0)
    }
    val shape = RoundedCornerShape(5.dp)
    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround

    ) {
        items(name.size) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .padding(bottom = 15.dp)
                    .clip(shape)
                    .clickable { selectedItemIndex = it }
                    .background(
                        if (selectedItemIndex == it) selectedFilterGreen
                        else FilterGreen
                    )
            ) {
                Text(
                    text = name[it],
                    color = Color.Black,
                    style = MaterialTheme.typography.h6,
                    modifier = Modifier.padding(all = 6.dp)
                )
            }
        }
    }
}

@Composable
fun Options() {
    val optionCardRepository = OptionCardRepository()
    val getAllData = optionCardRepository.getAllData()

    LazyColumn(
        modifier = Modifier.padding(bottom = 50.dp)
    ) {
        items(items = getAllData) { optionCard ->
            ОptionsBar(optionCard = optionCard)
        }
    }
}


@Composable
fun ОptionsBar(
    optionCard: OptionCard
) {
    Card(
        modifier = Modifier
            .padding(bottom = 14.dp),
        elevation = 4.dp,
    ) {
        Column(
            modifier = Modifier
                .background(CardYellow)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 8.dp, bottom = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    optionCard.from,
                    style = MaterialTheme.typography.h4,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold
                )
                Icon(
                    Icons.Default.ArrowForward,
                    contentDescription = ""
                )
                Text(
                    optionCard.to,
                    style = MaterialTheme.typography.h4,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 8.dp, bottom = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    optionCard.time,
                    style = MaterialTheme.typography.h4,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Medium,
                )
                Text(
                    modifier = Modifier.padding(start = 15.dp),
                    text = optionCard.date,
                    style = MaterialTheme.typography.h4,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Medium,
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 8.dp, bottom = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    modifier = Modifier.padding(end = 9.dp),
                    text = optionCard.seats,
                    style = MaterialTheme.typography.h4,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Medium,
                )
                Text(
                    text = "${optionCard.seatsAvailable}",
                    style = MaterialTheme.typography.h4,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                )
            }
            Button(
                modifier = Modifier
                    .padding(all = 5.dp)
                    .align(Alignment.Start),
                onClick = {},
                colors = ButtonDefaults.buttonColors(backgroundColor = ButtonColor)
            ) {
                Text(
                    text = "Забронировать",
                    style = MaterialTheme.typography.h4,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                )
            }
        }
    }
}


