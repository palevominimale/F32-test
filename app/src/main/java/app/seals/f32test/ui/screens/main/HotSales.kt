package app.seals.f32test.ui.screens.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import app.seals.f32test.R
import app.seals.f32test.ui.models.base.HomeStoreItemModel
import app.seals.f32test.ui.theme.Typography
import coil.compose.rememberAsyncImagePainter
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState

@OptIn(ExperimentalPagerApi::class)
@Composable
fun HotSales(
    list: List<HomeStoreItemModel>,
    modifier: Modifier = Modifier
) {

    val state = rememberPagerState()
    val imgUrl = remember { mutableStateOf("") }
    val title = remember { mutableStateOf("") }
    val subtitle = remember { mutableStateOf("") }
    val isNew = remember { mutableStateOf(false) }
    val isBuy = remember { mutableStateOf(false) }

    Column {
        Text(
            text = stringResource(id = R.string.main_hot_sales),
            modifier = modifier.padding(start = 16.dp, end = 16.dp, top = 8.dp),
            style = Typography.bodyLarge
        )
        HorizontalPager(
            count = list.size,
            state = state,
            modifier = Modifier
                .fillMaxWidth()
                .height(240.dp)
                .padding(vertical = 16.dp)
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
                        verticalArrangement = Arrangement.SpaceBetween,
                        horizontalAlignment = Alignment.Start,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(32.dp)
                    ) {
                        if(isNew.value) LabelNew()
                        MainText(title = title.value, subtitle = subtitle.value)
                        if(isBuy.value) BuyButton()
                    }
                }
            }
        }
    }
}

@Composable
private fun MainText(
    title: String, subtitle: String,
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start,
    ) {
        Box {
            Text(text = title, color = Color.Black,
                modifier = Modifier
                    .blur(20.dp)
                    .alpha(0.5f)
                    .offset(x = 0.5.dp, y = 0.5.dp)
            )
            Text(text = title, color = Color.White)
        }
        Box {
            Text(
                text = subtitle,
                color = Color.Black,
                style = Typography.labelMedium,
                modifier = Modifier
                    .blur(20.dp)
                    .alpha(0.5f)
                    .offset(x = 0.5.dp, y = 0.5.dp),
            )
            Text(
                text = subtitle,
                color = Color.White,
                style = Typography.labelMedium.copy(fontWeight = FontWeight.Thin),
            )
        }
    }

}

@Composable
private fun LabelNew() {
    Box(modifier = Modifier
        .size(32.dp)
        .shadow(3.dp, shape = CircleShape)
        .background(color = colorResource(R.color.main)),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "New",
            style = Typography.labelSmall,
            color = Color.White)

    }
}

@Composable
private fun BuyButton() {
    Button(
        modifier = Modifier
            .height(50.dp)
            .padding(vertical = 8.dp),
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