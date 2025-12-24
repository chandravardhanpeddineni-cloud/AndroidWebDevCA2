package com.example.practiceforca2

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.practiceforca2.ui.theme.PracticeForCA2Theme

class SecondActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val username = intent.getStringExtra("ITEM_NAME") ?: ""
            val usertype = intent.getIntExtra("QUANTITY",0).toString()
            PracticeForCA2Theme {
                SecondScreen(username, usertype)
            }
        }
    }
}

@Composable
fun SecondScreen(username: String, usertype: String) {
    val context = LocalContext.current

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(30.dp)){
        Text("Details", fontSize = 22.sp)
        Text("Username: $username")
        Text("Usertype: $usertype")
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview3() {
    PracticeForCA2Theme {
        SecondScreen("Android", "Developer")
    }
}