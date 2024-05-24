package eu.tutorials.myapplication10

import android.Manifest
import android.content.Context
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import androidx.core.content.ContextCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationResult
import com.google.android.gms.location.LocationServices

class LocationUtils(val context: Context) {

    private val _fusedLocationProviderClient:FusedLocationProviderClient =
        LocationServices.getFusedLocationProviderClient(context)

fun requestLocationUpdates(viewModel:LocationViewModel){
    val locationCallback=object:LocationCallback(){
        override fun onLocationResult(locationResult: LocationResult) {
            super.onLocationResult(locationResult)
            locationResult.lastLocation?.let{
                val location = LocationData(latitude=it.latitude,longitude=it.longitude)
            }
        }
    }
}




    fun hasLocationPermission(context:Context):Boolean{

    if (ContextCompat.checkSelfPermission(context,
            Manifest.permission.ACCESS_FINE_LOCATION)== PackageManager.PERMISSION_GRANTED
        &&
        ContextCompat.checkSelfPermission(context,
            Manifest.permission.ACCESS_COARSE_LOCATION)== PackageManager.PERMISSION_GRANTED
        ){

        return true

    }
    else {return false}
}

}