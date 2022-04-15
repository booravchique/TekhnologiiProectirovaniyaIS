package com.example.bus.ui.layot

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bus.R
import com.example.bus.ui.theme.ButtonColor
import com.example.bus.ui.theme.CardYellow
import com.example.bus.ui.theme.FilterGreen
import com.example.bus.ui.theme.RobotoFontFamily


@Preview
@Composable
fun ProfileScreen() {
    Box(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize()
            .padding(start = 12.dp, end = 12.dp, bottom = 50.dp)
    ) {
        Text(
            text = "Профиль",
            style = MaterialTheme.typography.h5,
            modifier = Modifier.padding(top = 25.dp),
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 60.dp)
        ) {
            PersonalInfo("Владислав", "25.06.2003", "+7950123123")
            PersonalContent()
        }
    }
}

@Composable
fun PersonalInfo(
    name: String,
    birthday: String,
    number: String
) {
    Card(
        elevation = 4.dp,
    ) {

        Column() {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 15.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround,
            ) {
                Image(
                    painter = painterResource(id = R.drawable.temp_avatar_two),
                    contentDescription = ""
                )
                Column(
                    modifier = Modifier
                ) {
                    Text(
                        text = name,
                        style = MaterialTheme.typography.h5
                    )
                    Text(
                        text = birthday,
                        style = MaterialTheme.typography.h4
                    )
                    Text(
                        text = number,
                        style = MaterialTheme.typography.h4
                    )
                }

            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp),
                verticalAlignment = Alignment.Top,
                horizontalArrangement = Arrangement.Center
            ) {
                Button(
                    onClick = { },
                    modifier = Modifier.padding(bottom = 10.dp),
                    shape = RoundedCornerShape(50),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = FilterGreen,
                        contentColor = Color.Black
                    )
                ) {
                    Text(
                        text = "Редактировать профиль",
                        fontFamily = RobotoFontFamily,
                        fontSize = 10.sp
                    )
                }
            }
        }
    }
}

@Composable
fun PersonalContent() {
    Column() {
        Text(
            modifier = Modifier
                .padding(top = 15.dp, bottom = 15.dp),
            text = "Совершенные поездки",
            style = MaterialTheme.typography.h5
        )
        Card(
            modifier = Modifier,
            elevation = 4.dp,
            ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(CardYellow)
                    .padding(start = 8.dp, bottom = 8.dp, top = 8.dp),
            ) {
                Row() {
                    Text(
                        text = "Краснотурьинск",
                        style = MaterialTheme.typography.h4,
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Icon(
                        Icons.Default.ArrowForward,
                        contentDescription = ""
                    )
                    Text(
                        text = "Екатеринбург",
                        style = MaterialTheme.typography.h4,
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
                Row(
                    modifier = Modifier
                ) {
                    Text(
                        text = "7:40",
                        style = MaterialTheme.typography.h4,
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        modifier = Modifier.padding(start = 25.dp),
                        text = "8 Апреля",
                        style = MaterialTheme.typography.h4,
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold
                    )

                }
                Button(
                    modifier = Modifier
                        .padding(top = 15.dp),
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(backgroundColor = ButtonColor)
                ) {
                    Text(
                        text = "Повторить",
                        style = MaterialTheme.typography.h4,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Black,
                    )
                }
            }
        }
    }
}