package app.seals.f32test.ui.screens.main.hotsales

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import app.seals.f32test.R
import app.seals.f32test.ui.main.vm.MainActivityViewModel
import app.seals.f32test.ui.models.hotsales.HomeStoreItemModel
import app.seals.f32test.ui.states.UiState
import coil.compose.rememberAsyncImagePainter
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import com.google.accompanist.placeholder.placeholder

@Composable
fun HotSales(vm: MainActivityViewModel) {

    val state by vm.state.collectAsState()

    when(state) {
        is UiState.IsReady -> Pager((state as UiState.IsReady).hotSales)
        else -> {}
    }


}

@OptIn(ExperimentalPagerApi::class)
@Composable
private fun Pager(list: List<HomeStoreItemModel>) {

    val state = rememberPagerState()
    val imgUrl = remember { mutableStateOf("") }
    val title = remember { mutableStateOf("") }
    val subtitle = remember { mutableStateOf("") }
    val isNew = remember { mutableStateOf(false) }
    val isBuy = remember { mutableStateOf(false) }

    HorizontalPager(
        count = list.size,
        state = state,
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .padding(vertical = 8.dp)
    ) { page ->
        imgUrl.value = list[page].picture.toString()
        title.value = list[page].title.toString()
        subtitle.value = list[page].subtitle.toString()
        isNew.value = list[page].isNew ?: false
        isBuy.value = list[page].isBuy ?: false

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start) {
            Box(
                contentAlignment = Alignment.BottomCenter
            ) {
                val painter = rememberAsyncImagePainter(imgUrl.value)
                Image(
                    painter = painter,
                    contentDescription = "",
                    modifier = Modifier
                        .padding(8.dp)
                        .clip(RoundedCornerShape(16.dp))
                        .fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.Start,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 32.dp)
                ) {
                    if(isNew.value) LabelNew()
                    Text(text = title.value, color = Color.White)
                    Text(text = subtitle.value, color = Color.White)
                    if(isBuy.value) BuyButton()

                }
            }
        }
    }
}

@Composable
private fun LabelNew() {
    Box(modifier = Modifier
        .size(40.dp)
        .shadow(3.dp, shape = CircleShape)
        .background(color = colorResource(R.color.main)),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "New", color = Color.White)

    }
}

@Composable
private fun BuyButton() {
    Button(
        modifier = Modifier.height(50.dp).padding(vertical = 8.dp),
        onClick = { /*TODO*/ },
        shape = RoundedCornerShape(8.dp),
        contentPadding = PaddingValues(0.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.White,
            contentColor = Color.Black
        ),
        content = {
            Text(
                text = "Buy now!",
                modifier = Modifier.padding(horizontal = 32.dp)
            )
        }
    )
}