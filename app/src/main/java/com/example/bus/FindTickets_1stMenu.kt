package com.example.bus

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
            TickedFinder()
            Filter(name = listOf("Дата", "Время", "Тип транспорта"))
        }
    }
}

@Composable
fun TickedFinder() {
    val shape = RoundedCornerShape(10.dp)
    val searchValue by remember { mutableStateOf("") }
    Column() {
        BasicTextField(
            value = searchValue,
            onValueChange = { searchValue },
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
                    if (searchValue.isEmpty()) {
                        Text("Poisk", style = MaterialTheme.typography.h5)
                    }
                    innerTextField()  //<-- Add this
                }
            },
        )

    }
}

@Composable
fun Filter(
    name: List<String>
) {
    var selectedItemIndex by remember {
        mutableStateOf(0)
    }
    val shape = RoundedCornerShape(10.dp)
    LazyRow() {
        items(name.size) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .padding(start = 15.dp, bottom = 15.dp)
                    .clip(shape)
                    .clickable { selectedItemIndex = it }
                    .background(
                        if (selectedItemIndex == it) selectedFilterGreen
                        else FilterGreen
                    )
            ) {
                Text(text = name[it],
                    color = Color.Black,
                    style = MaterialTheme.typography.h6,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(all = 5.dp))
            }
        }
    }

}

