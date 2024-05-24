package eu.tutorials.myapplication10

import android.Manifest
import android.content.Context
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.core.app.ActivityCompat
import androidx.lifecycle.viewmodel.compose.viewModel


@Composable
fun MyApp(viewModel:LocationViewModel){
    val context= LocalContext.current
    val localionUtils = LocationUtils(context)
    LocationDisplay(locationUtils = localionUtils, viewModel, context = context)
}




@Composable
fun LocationDisplay(
    locationUtils : LocationUtils,
    viewModel:LocationViewModel,
    context: Context
) {

    val requestPermissionLauncher = rememberLauncherForActivityResult(
        contract =ActivityResultContracts.RequestMultiplePermissions(),
    onResult =
    {
        permissions->if (permissions[Manifest.permission.ACCESS_COARSE_LOCATION]==true
        &&
        permissions[Manifest.permission.ACCESS_FINE_LOCATION]==true) {
//            I have access to location now
    }
        else
        {
//            ASK FOR permission
            val rationaleRequired = ActivityCompat.shouldShowRequestPermissionRationale(
                context as MainActivity,
                Manifest.permission.ACCESS_FINE_LOCATION
            )|| ActivityCompat.shouldShowRequestPermissionRationale(
                context as MainActivity,
                Manifest.permission.ACCESS_COARSE_LOCATION
            )
            if (rationaleRequired){
                Toast.makeText(context,"Location Permission is required for this feature",Toast.LENGTH_LONG).show()
            }
            else{
                Toast.makeText(context, "Location Permission is required Please enable it in settings.",Toast.LENGTH_LONG).show()
            }
        }
    }
    )
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(
            onClick = {
                if (locationUtils.hasLocationPermission(context)){

                }
                else{
                        requestPermissionLauncher.launch(
                            arrayOf(
                                Manifest.permission.ACCESS_FINE_LOCATION,
                                Manifest.permission.ACCESS_COARSE_LOCATION
                            )
                        )
                }
            }
        )
        {
            Text(text = "Get Current Location")
        }
    }
}