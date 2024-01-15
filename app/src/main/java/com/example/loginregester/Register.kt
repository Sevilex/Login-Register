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
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Email
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
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

//@Preview(showBackground = true)
@Composable
fun RegisterForm(
    navController: NavController,
) {
    if (isPersian) {
        CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {

                Image(
                    painter = painterResource(id = R.drawable.register_background),
                    contentDescription = "",
                    contentScale = ContentScale.Crop
                )

                Column {
                    Box(
                        Modifier.padding(
                            start = 180.dp,
                            top = 300.dp,
                            bottom = 100.dp
                        )
                    ) {
                        Text(
                            text = if (isPersian) "ثبت نام" else "Register",
                            fontSize = 48.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF666666),
                        )
                    }
                    Column {
                        UserNameField()
                        EmailFiled()
                        PasswordField()
                        CheckField()
                        ButtonLoginField(
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
                painter = painterResource(id = R.drawable.register_background),
                contentDescription = "",
                contentScale = ContentScale.Crop
            )

            Column {
                Box(
                    Modifier.padding(
                        start = 180.dp,
                        top = 300.dp,
                        bottom = 100.dp
                    )
                ) {
                    Text(
                        text = if (isPersian) "ثبت نام" else "Register",
                        fontSize = 48.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF666666),
                    )
                }
                Column {
                    UserNameField()
                    EmailFiled()
                    PasswordField()
                    CheckField()
                    ButtonLoginField(
                        navController = navController
                    )

                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun UserNameField() {
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
                tint = Color(0xFFFAFAFA)
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
fun EmailFiled() {
    var txt2 by remember { mutableStateOf("") }
    TextField(
        value = txt2,
        onValueChange = { txt2 = it },
        label = {
            Text(
                text = if (isPersian) "ایمیل" else "Email",
                fontWeight = FontWeight.Bold,
                color = Color(0xFFAAAAAA)
            )
        },
        //shape = RoundedCornerShape(topEnd = 48.dp),
        colors = TextFieldDefaults.textFieldColors(
            unfocusedIndicatorColor = Color(0xFFDDDDDD),
            focusedIndicatorColor = Color(0xFFCCCCCC),
            //backgroundColor = Color(0xFFFAFAFA)
        ),
        leadingIcon = {
            Icon(
                imageVector = Icons.Filled.Email,
                contentDescription = "",
                tint = Color(0xFFCCCCCC)
            )
        },
        modifier = Modifier
            .width(400.dp)
            .border(
                width = 1.dp,
                color = Color(0xFFDDDDDD),
                //shape = RoundedCornerShape(topEnd = 48.dp),
            )
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun PasswordField() {
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
            ),
        colors = TextFieldDefaults.textFieldColors(
            unfocusedIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            //backgroundColor = Color(0xFFFAFAFA)
        )
    )
}

@Composable
private fun CheckField() {
    Box(
        Modifier
            .absoluteOffset(
                if (isPersian) (-370).dp else 370.dp, (-120).dp
            )
    ) {
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
                imageVector = Icons.Filled.Check,
                contentDescription = "",
                tint = Color.White,
                modifier = Modifier.size(32.dp)
            )
        }
    }
}

@Composable
private fun ButtonLoginField(
    navController: NavController
) {
    Box(Modifier.fillMaxWidth(), Alignment.TopEnd) {
        Button(
            onClick = {
                navController.navigate(route = ServiceScreens.LoginScreen.name)
            },
            shape = RoundedCornerShape(
                topStart = 48.dp,
                bottomStart = 48.dp
            ),
            colors = ButtonDefaults.buttonColors(
                //backgroundColor = Color(0xFFFAFAFA),
                contentColor = Color(0xFFFF8F00),
            ),
            modifier = Modifier
                .shadow(
                    elevation = 5.dp,
                    shape = RoundedCornerShape(
                        topStart = 48.dp,
                        bottomStart = 48.dp
                    )
                )
                .border(
                    width = 1.dp,
                    color = Color(0xFFDDDDDD),
                    shape = RoundedCornerShape(
                        topStart = 48.dp,
                        bottomStart = 48.dp
                    )
                )
        ) {
            Text(
                text = if (isPersian) "ورود" else "Login",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(12.dp)
            )
        }
    }
}
