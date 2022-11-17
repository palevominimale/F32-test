package app.seals.f32test.ui.screens.splash

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import app.seals.f32test.R
import app.seals.f32test.ui.theme.Typography

@Composable
@Preview
fun SplashScreen() {
    val width = LocalConfiguration.current.screenWidthDp
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = colorResource(R.color.secondary)
    ) {
        Column (
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Surface(
                color = colorResource(R.color.secondary),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(135.dp)
            ) {
                Row(horizontalArrangement = Arrangement.Center) {
                    Surface(
                        shape = CircleShape,
                        color = colorResource(R.color.main),
                        modifier = Modifier.size(135.dp)
                    ) {}
                }
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = (width*0.4).dp),
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(text = "Ecommerce", style = Typography.bodyMedium.copy(color = Color.White))
                    Text(text = "Concept", style = Typography.bodyMedium.copy(color = Color.White))
                }
            }
        }
    }
}