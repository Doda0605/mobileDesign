package hr.ferit.vjezba1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import hr.ferit.vjezba1.ui.theme.Vjezba1Theme
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Vjezba1Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xFF92D050)
                ) {
                    Greeting("David", 1.74, 73.00)
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String,height: Double, weight: Double, modifier: Modifier = Modifier) {
    val bmi = weight / (height * height)
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Row {
            Text(
                text = "Pozdrav $name!",
                modifier = modifier,
                fontSize = 50.sp,
                lineHeight = 100.sp,
            )
        }
        Row {
            Text(
                text = "Tvoj BMI je:",
                fontSize = 50.sp,
                lineHeight = 100.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(16.dp)
            )
        }
        Row {
            Text(
                text = "%.0f".format(bmi),
                fontSize = 80.sp,
                lineHeight = 100.sp,
                textAlign = TextAlign.Center,
                color = when {
                    bmi < 20 -> Color.Red
                    bmi > 25 -> Color.Red
                    else -> Color(13, 117, 4)
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Vjezba1Theme {
        Greeting("David", 1.74, 73.00)
    }
}
