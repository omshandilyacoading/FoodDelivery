package eu.tutorials.myapplication10

import android.location.Location
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import eu.tutorials.myapplication10.trans
import eu.tutorials.myapplication10.ui.theme.MyApplication10Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel: LocationViewModel = viewModel()
            MyApplication10Theme {
                trans()
            }
        }
    }
}
