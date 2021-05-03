package dev.haroldjose.ominibus.android.Pages

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import dev.haroldjose.ominibus.android.Components.TestView
import dev.haroldjose.ominibus.android.Pages.ui.theme.OminibusTheme

class MapPage : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OminibusTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Column {
        Text(text = "Hello $name!")
        TestView("teste")
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    OminibusTheme {
        Greeting("Android")
    }
}