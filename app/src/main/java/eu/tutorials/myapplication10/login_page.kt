package eu.tutorials.myapplication10

import android.os.Environment
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import java.io.File
import java.io.FileWriter
import java.io.IOException



@Composable
fun login_page(navController: NavHostController) {
    var username = remember { mutableStateOf(TextFieldValue()) }
    val password = remember { mutableStateOf(TextFieldValue()) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Sign In", style = MaterialTheme.typography.headlineLarge)
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = username.value.text,
            onValueChange = { newValue -> username.value = TextFieldValue(newValue) },
            label = { Text("Username") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = password.value.text,
            onValueChange = { newValue -> password.value = TextFieldValue(newValue) },
            label = { Text("Password") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            // Clear text fields
            navController.navigate("Page_three")
            username.value = TextFieldValue()
            password.value = TextFieldValue()

            // Store data in CSV file
            val csvFile = File(Environment.getExternalStorageDirectory(), "userdata.csv")

            try {
                csvFile.createNewFile() // Create the file if it doesn't exist
                val csvWriter = FileWriter(csvFile, true)
                val data = arrayOf(username.value.text, password.value.text)
                csvWriter.append(data.joinToString(","))
                csvWriter.append("\n") // Append new line
                csvWriter.flush()
                csvWriter.close()
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }) {
            Text(text = "Sign In")
        }

    }}