package eu.tutorials.myapplication10


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import eu.tutorials.foodapplication.R

@Composable
fun First_Page(navController: NavHostController){

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.Gray,
//                    color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 50.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Food Image",
                modifier = Modifier
                    .size(150.dp)
                    .clip(shape = CircleShape)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Deliver Food",
                style = MaterialTheme.typography.headlineLarge,
                color = Color.Red
            )
            Spacer(modifier = Modifier.height(20.dp)) // Add spacing above the button
            Button(
                onClick = { navController.navigate("login_page") },
                shape = RectangleShape,
                modifier = Modifier
                    .height(50.dp)
                    .padding(horizontal = 16.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Black
                )
            ) {
                Text(text = "Enter")
            }
        }
    }
}