package com.example.bus

import android.app.Application
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bus.entity.loginInfo
import com.example.bus.ui.theme.BUSTheme
import com.example.bus.ui.theme.RobotoFontFamily
import com.example.bus.viewmodel.asdViewModel
import com.example.bus.viewmodel.asdViewModelFactory

class MainActivity : ComponentActivity() {
    val vm by viewModels<asdViewModel>{ asdViewModelFactory(applicationContext as Application)}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BUSTheme {
                LogInComposable(vm)
            }
        }
    }
}


@Composable
fun LogInComposable(
    vm : asdViewModel
) {

    val shape = RoundedCornerShape(30.dp)
    val LoginValue = remember { mutableStateOf("") }
    val PasswordValue = remember { mutableStateOf("") }

    val context = LocalContext.current

    val loginInfoData = listOf(loginInfo(1, "User1", "User1"))

    Box(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = stringResource(R.string.LogInScreenIntro),
                modifier = Modifier
                    .padding(bottom = 40.dp),
                style = MaterialTheme.typography.h3,

                )
            TextField(
                value = LoginValue.value,
                onValueChange = { LoginValue.value = it },
                modifier = Modifier
                    .width(290.dp)
                    .height(70.dp)
                    .padding(top = 10.dp, bottom = 10.dp)
                    .clip(shape)
                    .border(
                        BorderStroke(1.dp, color = Color.Black),
                        shape = shape
                    ),
                label = { Text(text = stringResource(R.string.login)) },
                singleLine = true,
                colors = TextFieldDefaults.textFieldColors(backgroundColor = Color.White)
            )
            TextField(
                value = PasswordValue.value,
                onValueChange = { PasswordValue.value = it },
                modifier = Modifier
                    .width(290.dp)
                    .height(70.dp)
                    .padding(top = 10.dp, bottom = 10.dp)
                    .clip(shape)
                    .border(
                        BorderStroke(1.dp, color = Color.Black),
                        shape = shape
                    ),
                label = { Text(text = stringResource(R.string.password)) },
                singleLine = true,
                colors = TextFieldDefaults.textFieldColors(backgroundColor = Color.White)
            )
            Button(
                onClick = {
                    vm.addInfo(loginInfoData)
                    //LoginFun(Login = LoginValue.value, Password = PasswordValue.value)
                },
                modifier = Modifier
                    .padding(top = 55.dp)
                    .width(130.dp),
                shape = RoundedCornerShape(50),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.Black, // создать цветовую схему
                    contentColor = Color.White
                )
            ) {
                Text(
                    text = "Вход",
                    fontFamily = RobotoFontFamily,
                    fontSize = 20.sp
                )
            }
            Text(
                text = "Зарегистрироваться",
                modifier = Modifier
                    .clickable {}
                    .padding(top = 35.dp),
                style = MaterialTheme.typography.h5,
            )

        }
    }
}

fun LoginFun(Password: String, Login: String) {
    if (Password.isNotEmpty() && Login.isNotEmpty()) {
        if (Login == "User" && Password == "User") {
            //navigation
        } else {
            //неправильный логин или пароль и желательно поменять цвет
        }
    } else {
        //toast ошибка
    }
}




