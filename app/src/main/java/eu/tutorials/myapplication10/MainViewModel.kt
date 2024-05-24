package eu.tutorials.myapplication10


import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch


class MainViewModel: ViewModel(){
    private val _categorieState = mutableStateOf(RecipeState())
    val categoriesState: State<RecipeState> = _categorieState
    val selectedImageNames = mutableStateListOf<String>()


    fun addSelectedImageName(imageName: String) {
        if (!selectedImageNames.contains(imageName)) {
            selectedImageNames.add(imageName)
        }
    }

    fun removeSelectedImageName(imageName: String) {
        selectedImageNames.remove(imageName)
    }

    init {
        fetchCategories()
    }
    private fun fetchCategories() {
        viewModelScope.launch {
            try {
                val response=recipeService.getCategories()
                _categorieState.value=_categorieState.value.copy(
                    list = response.categories,
                    loading = false,
                    error = null
                )
            }
            catch(e:Exception){
                _categorieState.value=_categorieState.value.copy(
                    loading=false,
                    error = "Error fetching Categories ${e.message}"
                )
            }
        }
    }
    data class RecipeState(
        val loading: Boolean=true,
        val list: List<Category> = emptyList(),
        val error:String?=null
    )

}
