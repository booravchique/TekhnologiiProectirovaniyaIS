package com.example.bus

import android.app.Application
import android.view.View
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
import androidx.compose.runtime.rememberCompositionContext
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.bus.entity.loginInfo
import com.example.bus.ui.theme.RobotoFontFamily
import com.example.bus.ui.theme.robotoTypography
import com.example.bus.viewmodel.asdViewModel
import com.example.bus.viewmodel.asdViewModelFactory

//@Composable
//fun LogInComposable() {
//    val shape = RoundedCornerShape(30.dp)
//    val LoginValue = remember { mutableStateOf("") }
//    val PasswordValue = remember { mutableStateOf("") }
//
//    val context = LocalContext.current
//
//    val viewModel: asdViewModel =  viewModel(
//        factory = asdViewModelFactory(context.applicationContext as Application)
//    )
//
//    val loginInfoData = listOf(loginInfo(1, "User1","User1"))
//
//    Box(
//        modifier = Modifier
//            .background(White)
//            .fillMaxSize(),
//        contentAlignment = Alignment.Center
//    ) {
//        Column(
//            modifier = Modifier
//                .fillMaxWidth(),
//            horizontalAlignment = Alignment.CenterHorizontally,
//            verticalArrangement = Arrangement.Center
//        ) {
//            Text(
//                text = stringResource(R.string.LogInScreenIntro),
//                modifier = Modifier
//                    .padding(bottom = 40.dp),
//                style = MaterialTheme.typography.h3,
//
//                )
//            TextField(
//                value = LoginValue.value,
//                onValueChange = { LoginValue.value = it },
//                modifier = Modifier
//                    .width(290.dp)
//                    .height(70.dp)
//                    .padding(top = 10.dp, bottom = 10.dp)
//                    .clip(shape)
//                    .border(
//                        BorderStroke(1.dp, color = Black),
//                        shape = shape
//                    ),
//                label = { Text(text = stringResource(R.string.login)) },
//                singleLine = true,
//                colors = TextFieldDefaults.textFieldColors(backgroundColor = White)
//            )
//            TextField(
//                value = PasswordValue.value,
//                onValueChange = { PasswordValue.value = it },
//                modifier = Modifier
//                    .width(290.dp)
//                    .height(70.dp)
//                    .padding(top = 10.dp, bottom = 10.dp)
//                    .clip(shape)
//                    .border(
//                        BorderStroke(1.dp, color = Black),
//                        shape = shape
//                    ),
//                label = { Text(text = stringResource(R.string.password)) },
//                singleLine = true,
//                colors = TextFieldDefaults.textFieldColors(backgroundColor = White)
//            )
//            Button(
//                onClick = {
//                    vm.addInfo(loginInfoData)
//                    //LoginFun(Login = LoginValue.value, Password = PasswordValue.value)
//                },
//                modifier = Modifier
//                    .padding(top = 55.dp)
//                    .width(130.dp),
//                shape = RoundedCornerShape(50),
//                colors = ButtonDefaults.buttonColors(
//                    backgroundColor = Color.Black, // создать цветовую схему
//                    contentColor = White
//                )
//            ) {
//                Text(
//                    text = "Вход",
//                    fontFamily = RobotoFontFamily,
//                    fontSize = 20.sp
//                )
//            }
//            Text(
//                text = "Зарегистрироваться",
//                modifier = Modifier
//                    .clickable {}
//                    .padding(top = 35.dp),
//                style = MaterialTheme.typography.h5,
//            )
//
//        }
//    }
//}
//
//fun LoginFun(Password: String, Login: String) {
//    if (Password.isNotEmpty() && Login.isNotEmpty()) {
//        if (Login == "User" && Password == "User") {
//            //navigation
//        } else {
//            //неправильный логин или пароль и желательно поменять цвет
//        }
//    } else {
//        //toast ошибка
//    }
//}
