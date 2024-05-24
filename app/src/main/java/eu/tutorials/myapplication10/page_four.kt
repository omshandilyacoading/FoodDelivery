package eu.tutorials.myapplication10

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import eu.tutorials.myapplication10.MainViewModel

@Composable
fun Page_four(navController: NavHostController, recipeViewModel: MainViewModel) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(0.dp)
            .background(Color(0xFF424242)),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        Text("Selected Food Items", style = MaterialTheme.typography.headlineLarge, color = Color(0xFFFF7043))
        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {
            items(recipeViewModel.selectedImageNames) { imageName ->
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(2.dp)
                        .clickable {

                        }
                        .background(Color(0xFF424242))
                        .padding(5.dp),
                    contentAlignment = Alignment.TopStart
                ) {
                    Text(
                        text = imageName,
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Start
                    )
                }
            }
        }
    }
}
