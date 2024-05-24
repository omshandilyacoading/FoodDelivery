package eu.tutorials.myapplication10


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import coil.compose.rememberImagePainter


@Composable
fun Page_three(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    recipeViewModel: MainViewModel = viewModel() // Inject the view model
) {
    val viewstate by recipeViewModel.categoriesState

    Box(modifier = Modifier.fillMaxSize().background(Color.Black)) {
        // Your existing code

        CategoryScreen(
            categories = viewstate.list,
            onCategoryClicked = { categoryName ->
                if (recipeViewModel.selectedImageNames.contains(categoryName)) {
                    recipeViewModel.removeSelectedImageName(categoryName)
                } else {
                    recipeViewModel.addSelectedImageName(categoryName)
                }
            },
            selectedImageNames = recipeViewModel.selectedImageNames
        )

        // Your existing code

        Button(
            onClick = {
                navController.navigate("Page_four")
            },
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 16.dp)
        ) {
            Text("Move to Cart")
        }
    }
}


@Composable
fun CategoryScreen(
    categories: List<Category>,
    onCategoryClicked: (String) -> Unit,
    selectedImageNames: MutableList<String> // Change to MutableList<String>
) {
    LazyVerticalGrid(GridCells.Fixed(2), modifier = Modifier.fillMaxSize()) {
        items(categories) { category ->
            CategoryItem(
                category = category,
                onCategoryClicked = onCategoryClicked,
                selectedImageNames = selectedImageNames
            )
        }
    }
}

@Composable
fun CategoryItem(
    category: Category,
    onCategoryClicked: (String) -> Unit,
    selectedImageNames: MutableList<String>
) {
    Column(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxSize()
            .background(Color.Black)
    ) {
        // Image with clickable functionality
        Image(
            painter = rememberImagePainter(category.strCategoryThumb),
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize()
                .aspectRatio(1f)
                .clickable {
                    onCategoryClicked(category.strCategory)
                    selectedImageNames.add(category.strCategory) // Update the list of selected image names
                }
        )

        // Header with category name
        Box(
            modifier = Modifier
                .height(30.dp)
                .fillMaxWidth()
                .background(Color(0xFFFFA500)) // Orange color
        ) {
            Text(
                text = category.strCategory,
                color = Color.White,
                style = TextStyle(fontWeight = FontWeight.Bold),
                modifier = Modifier
                    .padding(top = 4.dp)
                    .fillMaxWidth(), // Ensure the text takes up the full width
                textAlign = TextAlign.Center
            )
        }
    }
}

