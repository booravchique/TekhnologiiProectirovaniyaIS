package com.example.bus

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bus.ui.theme.BUSTheme

class FindTickets_1stMenu : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BUSTheme {

            }
        }
    }
}


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
        }
    }
}

@Composable
fun TickedFinder() {
    val searchValue = remember { mutableStateOf("") }
    Column() {
        TextField(
            value = searchValue.value,
            onValueChange = { searchValue.value = it },
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp)
                .padding(top = 10.dp, bottom = 10.dp)
                .border(
                    BorderStroke(1.dp, color = Color.Black),
                ),
            placeholder = { Text(text = stringResource(R.string.search)) },
            singleLine = true,
            colors = TextFieldDefaults.textFieldColors(backgroundColor = Color.White)
        )
    }
}

@Composable
fun SearchFilter(name: String) {
    
}