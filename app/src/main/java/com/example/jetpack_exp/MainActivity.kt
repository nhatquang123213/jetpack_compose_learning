package com.example.happybirthday

import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jetpack_exp.Product
import com.example.jetpack_exp.ProductCard
import com.example.jetpack_exp.R
import com.example.jetpack_exp.sampleProducts
import com.example.jetpack_exp.ui.theme.Jetpack_ExpTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Jetpack_ExpTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GreetingText(
                        message = "Happy Birthday Sam!",
                        from = "From Emma",
                        modifier = Modifier.padding(8.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun GreetingText(message: String, from: String, modifier: Modifier = Modifier) {
    val navController=rememberNavController()
    NavHost(navController = navController, startDestination = "home"){
        composable ("home"){ HomePage(navController) }
        composable("detail") { DetailScreen(navController) }
    }
}

@Composable
fun HomePage( navController: NavController) {
    var products  by remember { mutableStateOf(sampleProducts) }

    Column {
        Button(
            onClick = {
                products = products + Product(
                    id = products.size + 1,
                    name = "New Item ${products.size + 1}",
                    price = (100..200).random().toDouble(),
                    imageUrl = "https://picsum.photos/${200 + products.size}"
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Text("Add Product")
        }
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
        ) {
            items(products) { item ->
                ProductCard(product = item,  modifier =  Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .clickable {
                        navController.navigate("detail")
                    })
            }

        }
    }
}

@Composable
fun DetailScreen( navController: NavController) {

    Column {
        Text("Detail Product")
    }
}

@Preview(showBackground = true)
@Composable
fun BirthdayCardPreview() {
    Jetpack_ExpTheme {
        GreetingText(message = "Happy Birthday Sam!", from = "From Emma")
    }
}