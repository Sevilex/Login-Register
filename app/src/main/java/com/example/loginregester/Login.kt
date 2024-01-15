package com.example.loginregester

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

//@Preview(showBackground = true)
@Composable
fun LoginForm(
    navController: NavController,
) {
    if (isPersian) {
        CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {

            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                Image(
                    painter = painterResource(id = R.drawable.login_background),
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                )

                Column {
                    Box(
                        Modifier.padding(
                            start = 200.dp,
                            top = 300.dp,
                            bottom = 80.dp
                        )
                    ) {
                        Text(
                            text = if (isPersian) "ورود" else "Login",
                            fontSize = 48.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF666666),
                        )
                    }
                    Column {
                        UserNameFieldLogin()
                        PasswordFieldLogin()
                        ArrowForwardFieldLogin()
                        ForgetFieldLogin()
                        RegisterFieldLogin(
                            navController = navController
                        )
                    }
                }
            }
        }
    } else {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Image(
                painter = painterResource(id = R.drawable.login_background),
                contentDescription = "",
                contentScale = ContentScale.Crop,
            )

            Column {
                Box(
                    Modifier.padding(
                        start = 200.dp,
                        top = 300.dp,
                        bottom = 80.dp
                    )
                ) {
                    Text(
                        text = if (isPersian) "ورود" else "Login",
                        fontSize = 48.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF666666),
                    )
                }
                Column {
                    UserNameFieldLogin()
                    PasswordFieldLogin()
                    ArrowForwardFieldLogin()
                    ForgetFieldLogin()
                    RegisterFieldLogin(
                        navController = navController
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserNameFieldLogin() {
    var txt by remember { mutableStateOf("") }

    TextField(
        value = txt,
        onValueChange = { txt = it },
        label = {
            Text(
                text = if (isPersian) "نام کاربری" else "UserName",
                fontWeight = FontWeight.Bold,
                color = Color(0xFFAAAAAA)
            )
        },
        shape = RoundedCornerShape(topEnd = 48.dp),
        colors = TextFieldDefaults.textFieldColors(
            unfocusedIndicatorColor = Color(0xFFDDDDDD),
            focusedIndicatorColor = Color(0xFFCCCCCC),
            //backgroundColor = Color(0xFFFAFAFA)
        ),
        leadingIcon = {
            Icon(
                imageVector = Icons.Filled.Person,
                contentDescription = "",
                tint = Color(0xFFCCCCCC)
            )
        },
        modifier = Modifier
            .width(400.dp)
            .border(
                width = 1.dp,
                color = Color(0xFFDDDDDD),
                shape = RoundedCornerShape(topEnd = 48.dp),
            )
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordFieldLogin() {
    var password by remember { mutableStateOf("") }

    TextField(
        value = password,
        onValueChange = { password = it },
        label = {
            Text(
                text = if (isPersian) "رمز عبور" else "Password",
                fontWeight = FontWeight.Bold,
                color = Color(0xFFAAAAAA)
            )
        },
        shape = RoundedCornerShape(bottomEnd = 48.dp),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password
        ),
        visualTransformation = PasswordVisualTransformation(),
        colors = TextFieldDefaults.textFieldColors(
            unfocusedIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            //backgroundColor = Color(0xFFFAFAFA)
        ),
        leadingIcon = {
            Icon(
                imageVector = Icons.Filled.Lock,
                contentDescription = "",
                tint = Color(0xFFCCCCCC)
            )
        },
        modifier = Modifier
            .width(400.dp)
            .shadow(
                elevation = 10.dp,
                shape = RoundedCornerShape(bottomEnd = 48.dp)
            )
    )
}

@Composable
fun ArrowForwardFieldLogin() {
    Box(Modifier.absoluteOffset(if (isPersian) (-370).dp else 350.dp, (-90).dp)) {
        IconButton(
            onClick = {},
            modifier = Modifier
                .size(64.dp)
                .clip(CircleShape)
                .background(
                    color = Color(0xFF44DD88)
                )
                .border(
                    width = 2.dp,
                    color = Color(0x8844AA88),
                    shape = CircleShape
                )
        ) {
            Icon(
                imageVector = Icons.Filled.ArrowForward,
                contentDescription = "",
                tint = Color.White,
                modifier = Modifier.size(32.dp)
            )
        }
    }
}

@Composable
fun ForgetFieldLogin() {

    Box(
        Modifier
            .fillMaxWidth()
            .padding(10.dp), Alignment.TopEnd
    ) {
        Text(
            text = if (isPersian) "فراموشی رمز" else "Forget ?",
            fontSize = 16.sp,
            color = Color(0xFF888888)
        )
    }
}

@Composable
fun RegisterFieldLogin(
    navController: NavController
) {
    Box(Modifier.fillMaxWidth(), Alignment.TopStart) {
        Button(
            onClick = {
                navController.navigate(route = ServiceScreens.RegisterScreen.name)
            },
            shape = RoundedCornerShape(
                topEnd = 48.dp,
                bottomEnd = 48.dp
            ),
            colors = ButtonDefaults.buttonColors(
                //backgroundColor = Color(0xFFFAFAFA),
                contentColor = Color(0xFFFF8F00),
            ),
            modifier = Modifier
                .shadow(
                    elevation = 5.dp,
                    shape = RoundedCornerShape(
                        topEnd = 48.dp,
                        bottomEnd = 48.dp
                    )
                )
                .border(
                    width = 1.dp,
                    color = Color(0xFFDDDDDD),
                    shape = RoundedCornerShape(
                        topEnd = 48.dp,
                        bottomEnd = 48.dp
                    )
                )
        ) {
            Text(
                text = if (isPersian) "ثبت نام" else "Register",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(12.dp)
            )
        }
    }
}
