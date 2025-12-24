package com.example.practiceforca2

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.practiceforca2.ui.theme.PracticeForCA2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PracticeForCA2Theme {
                FirstScreen()
            }
        }
    }
}

@Composable
fun FirstScreen() {
    val context = LocalContext.current
    var item_name by remember { mutableStateOf("") }
    var quantity by remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(30.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text("First Screen", fontSize = 22.sp)
        Spacer(modifier = Modifier.height(20.dp))
        TextField(
            value = item_name,
            onValueChange = { item_name = it },
            label = { Text("Enter the Item Name") }
        )
        Spacer(modifier = Modifier.padding(8.dp))
        TextField(
            value = quantity,
            onValueChange = { quantity = it },
            label = { Text("Enter the Quantity") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        Spacer(modifier = Modifier.padding(8.dp))
        Button(onClick = {
            val quantityInt = quantity.toIntOrNull() ?: 0
            if (quantityInt > 0) {
                val intent = Intent(context, SecondActivity::class.java)
                intent.putExtra("ITEM_NAME", item_name)
                intent.putExtra("QUANTITY", quantityInt)
                context.startActivity(intent)
            } else {
                Toast.makeText(context, "Quantity must be a greater than zero", Toast.LENGTH_SHORT).show()
            }
        }) {
            Text("Go to Next Screen")
        }

    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    PracticeForCA2Theme {
        FirstScreen()
    }
}
