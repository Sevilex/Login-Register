package com.example.loginregester

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.loginregester.ui.theme.LoginRegesterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginRegesterTheme {
                RegisterForm()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RegisterForm() {
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
                modifier = Modifier.padding(
                    top = 300.dp,
                    start = 200.dp,
                    bottom = 100.dp
                )
            ) {
                Text(
                    text = "Register",
                    //fontSize = 48.dp,
                    modifier = Modifier.padding(1.dp),
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF666666),
                )
            }
            Column {
                UserNameField()
                EmailFiled()
                PasswordField()
                CheckField()
                ButtonField()

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
                text = "UserName",
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
                text = "Email",
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
                text = "Password",
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
private fun CheckField(){
    Box(Modifier.absoluteOffset(370.dp, (-120).dp)) {
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
                tint = White,
                modifier = Modifier.size(32.dp)
            )
        }
    }
}

@Composable
private fun ButtonField(){
    Box(Modifier.fillMaxWidth(), Alignment.TopEnd) {
        Button(
            onClick = {},
            shape = RoundedCornerShape(
                topStart= 48.dp,
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
                text = "Login",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(12.dp)
            )
        }
    }
}
