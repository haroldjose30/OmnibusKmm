package dev.haroldjose.ominibus.android.Pages

import androidx.activity.compose.setContent
import dev.haroldjose.ominibus.android.Pages.ui.theme.OminibusTheme

import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.ui.tooling.preview.Preview
import dev.haroldjose.ominibus.android.Components.TestView
import dev.haroldjose.ominibus.android.Pages.ui.theme.OminibusTheme

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.VisibleForTesting
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.view.WindowCompat
import com.google.android.libraries.maps.CameraUpdateFactory
import com.google.android.libraries.maps.MapView
import com.google.android.libraries.maps.model.LatLng
import com.google.maps.android.ktx.addMarker
import com.google.maps.android.ktx.awaitMap
import dev.haroldjose.ominibus.android.R
import kotlinx.coroutines.launch
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.*
import androidx.compose.material.icons.rounded.Directions
import androidx.compose.material.icons.rounded.DirectionsWalk
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

class GetInPage : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OminibusTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    GetInPageContent(rememberNavController())
                }
            }
        }
    }
}



@Composable
fun GetInPageContent(navController: NavController) {
    var number by remember { mutableStateOf("") }
    var name by remember { mutableStateOf("") }
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Icon(Icons.Rounded.DirectionsWalk, contentDescription = "")

        Spacer(Modifier.height(16.dp))

        Text("Número da linha")
        TextField(
            value = number,
            onValueChange = { number = it },
            label = { Text("Ex: 022") }
        )

        Spacer(Modifier.height(16.dp))

        Text("Descrição da linha")
        TextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Ex: nterbairros II") }
        )

        Spacer(Modifier.height(16.dp))

        Button(onClick = { /*TODO*/ }) {
            Text("Embarcar")
        }
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
        GetInPageContent(rememberNavController())
}