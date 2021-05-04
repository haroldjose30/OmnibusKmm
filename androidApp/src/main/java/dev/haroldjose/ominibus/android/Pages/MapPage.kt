package dev.haroldjose.ominibus.android.Pages


import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.ui.tooling.preview.Preview
import dev.haroldjose.ominibus.android.Components.TestView
import dev.haroldjose.ominibus.android.Pages.ui.theme.OminibusTheme

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.VisibleForTesting
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.view.WindowCompat
import com.google.android.libraries.maps.CameraUpdateFactory
import com.google.android.libraries.maps.MapView
import com.google.android.libraries.maps.model.LatLng
import com.google.maps.android.ktx.addMarker
import com.google.maps.android.ktx.awaitMap
import kotlinx.coroutines.launch



//import dev.haroldjose.ominibus.Greeting
//
//fun greet(): String {
//    return Greeting().greeting()
//}
//
//@Composable
//fun Greeting(name: String) {
//    Column {
//        Text(text = name)
//        TestView("teste")
//    }
//}

private const val InitialZoom = 5f
const val MinZoom = 2f
const val MaxZoom = 20f

class MapPage : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            OminibusTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    DetailsContent()
                }
            }
        }
    }
}


@Composable
fun DetailsContent(
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier, verticalArrangement = Arrangement.Center) {
        Spacer(Modifier.height(32.dp))
        Text(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            text = "city.nameToDisplay",
            style = MaterialTheme.typography.h4
        )
        Text(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            text = "description",
            style = MaterialTheme.typography.h6
        )
        Spacer(Modifier.height(16.dp))
        CityMapView(latitude.toString(), longitude.toString())
    }
}

@Composable
private fun CityMapView(latitude: String, longitude: String) {
    // The MapView lifecycle is handled by this composable. As the MapView also needs to be updated
    // with input from Compose UI, those updates are encapsulated into the MapViewContainer
    // composable. In this way, when an update to the MapView happens, this composable won't
    // recompose and the MapView won't need to be recreated.
    val mapView = rememberMapViewWithLifecycle()
    MapViewContainer(mapView, latitude, longitude)
}


const val latitude = 40.75773
const val longitude = -73.985708

const val latitude1 = 40.755560578456745
const val longitude1 = -73.98229739305718


@Composable
private fun MapViewContainer(
    map: MapView,
    latitude: String,
    longitude: String,
    modifier: Modifier = Modifier
) {
    var mapInitialized by remember(map) { mutableStateOf(false) }
    LaunchedEffect(map, mapInitialized) {
        if (!mapInitialized) {
            val googleMap = map.awaitMap()
            val position = LatLng(latitude.toDouble(), longitude.toDouble())
            googleMap.addMarker {
                position(position)
                title("Marker Title 1")
            }

            val position1 = LatLng(latitude1.toDouble(), longitude1.toDouble())
            googleMap.addMarker {
                position(position1)
                title("Marker Title 2")
            }

            googleMap.moveCamera(CameraUpdateFactory.newLatLng(position))
            mapInitialized = true
        }
    }

    val coroutineScope = rememberCoroutineScope()
    AndroidView({ map }) { mapView ->
        coroutineScope.launch {
            mapView.awaitMap()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    DetailsContent()
}