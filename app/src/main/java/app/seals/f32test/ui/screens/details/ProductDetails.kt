package app.seals.f32test.ui.screens.details

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Done
import androidx.compose.material.icons.outlined.KeyboardArrowLeft
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.Light
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.graphics.toColorInt
import app.seals.f32test.R
import app.seals.f32test.ui.models.DetailsModel
import app.seals.f32test.ui.sampledata.DataPump
import app.seals.f32test.ui.theme.Typography
import coil.compose.AsyncImage
import kotlin.math.roundToInt

@Composable
@Preview
fun ProductDetails(item: DetailsModel = DataPump.detailsModel) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TopRow(
            onDismiss = {},
            modifier = Modifier
                .padding(16.dp))
        ImagesRow(item)
        ItemCard(item)
    }
}

@Composable
private fun TopRow(onDismiss: () -> Unit, modifier: Modifier = Modifier) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        Button(
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier
                .size(40.dp),
            contentPadding = PaddingValues(0.dp),
            onClick = { onDismiss() },
            enabled = true,
            colors = ButtonDefaults
                .buttonColors(containerColor = colorResource(id = R.color.secondary))
        ) {
            Icon(
                modifier = Modifier
                    .size(30.dp),
                imageVector = Icons.Outlined.KeyboardArrowLeft,
                tint = Color.White,
                contentDescription = null
            )
        }
        Text(
            text = stringResource(id = R.string.details_top),
            style = Typography.labelLarge
        )
        Button(
            modifier = Modifier
                .size(40.dp),
            contentPadding = PaddingValues(0.dp),
            onClick = { onDismiss() },
            enabled = true,
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults
                .buttonColors(containerColor = colorResource(id = R.color.main))) {
            Icon(
                modifier = Modifier
                    .size(20.dp),
                imageVector = Icons.Outlined.ShoppingCart,
                tint = Color.White,
                contentDescription = null
            )
        }
    }
}

@Composable
private fun ImagesRow(item: DetailsModel = DataPump.detailsModel, modifier: Modifier = Modifier) {

    val width = LocalConfiguration.current.screenWidthDp*0.7

    LazyRow(
        modifier = modifier
            .padding(vertical = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        item.images.forEach {
            item {
                AsyncImage(
                    model = it,
                    contentDescription = item.title,
                    modifier = Modifier
                        .height(300.dp)
                        .width(width.dp)
                        .fillMaxSize()
                        .clip(RoundedCornerShape(16.dp))
                        .padding(8.dp)
                )
            }
        }
    }

}

@Composable
private fun ItemCard(item: DetailsModel, modifier: Modifier = Modifier) {
    val tabItems = listOf(
        "Shop",
        "Details",
        "Features"
    )
    Surface(
        modifier = modifier
            .background(
                color = Color.White,
                shape = RoundedCornerShape(24.dp)
            )
            .shadow(
                elevation = 5.dp,
                shape = RoundedCornerShape(24.dp)
            )
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp),
        ) {
            LabelRow(
                isFavorite = item.isFavorites ?: false,
                label = item.title.toString()
            )
            RatingStartsRow(
                rating = item.rating
            )
            TabsRow(
                modifier = Modifier
                    .padding(16.dp),
                tabItems = tabItems
            )
            SpecsRow(item)
            ColorSelector(
                colors = item.color,
                memory = item.capacity,
                modifier = Modifier
                    .padding(vertical = 16.dp)
            )
            AddToCart(
                price = item.price.toString()
            )
        }
    }
}

@Composable
private fun LabelRow(isFavorite: Boolean, label: String) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        Text(
            text = label,
            style = Typography.bodyLarge.copy(fontWeight = FontWeight.Light)
        )
        Surface(
            modifier = Modifier
                .size(40.dp),
            shape = RoundedCornerShape(10.dp),
            color = colorResource(if(isFavorite) R.color.main else R.color.secondary)
        ) {
            Icon(
                modifier = Modifier
                    .padding(8.dp)
                    .size(20.dp),
                painter = painterResource(id = R.drawable.ic_baseline_favorite_border_24),
                tint = Color.White,
                contentDescription = null
            )
        }
    }
}

@Composable
private fun RatingStartsRow(rating: Double?, modifier: Modifier = Modifier) {
    if (rating != null) {
        Row(modifier = modifier
            .padding(horizontal = 12.dp, vertical = 0.dp)
            .width(180.dp),
            horizontalArrangement = Arrangement.Start
        ) {
            repeat(5) {
                Icon(
                    imageVector = Icons.Default.Star,
                    contentDescription = null,
                    tint = if(it+1<=rating.roundToInt()) colorResource(id = R.color.stars)
                            else Color.LightGray,
                    modifier = Modifier
                        .padding(horizontal = 4.dp)
                        .size(16.dp)
                )
            }
        }
    }
}

@Composable
private fun TabsRow(tabItems: List<String>, modifier: Modifier = Modifier) {

    var tabIndex by remember { mutableStateOf(0) }

    TabRow(
        modifier = modifier,
        selectedTabIndex = 0,
        contentColor = Color.Black,
        divider = {},
        indicator = { tabPositions ->
            Box(
                modifier = Modifier
                    .tabIndicatorOffset(tabPositions[tabIndex])
                    .height(4.dp)
                    .padding(horizontal = 16.dp)
                    .clip(RoundedCornerShape(2.dp))
                    .background(color = colorResource(R.color.main))
            )
        }
    ) {
        tabItems.forEachIndexed { index, item ->
            Tab(
                selected = tabIndex == index,
                onClick = { tabIndex = index },
                selectedContentColor = Color.Black,
                unselectedContentColor = Color.Black,
            ) {
                Text(
                    modifier = Modifier.padding(8.dp),
                    text = item,
                    style = Typography.labelLarge
                )
            }
        }
    }
}

@Composable
private fun SpecsRow(item: DetailsModel, modifier: Modifier = Modifier) {

    val types = listOf(
        item.CPU,
        item.camera,
        item.ssd,
        item.sd
    )

    val icons = listOf(
        painterResource(id = R.drawable.ic_outline_memory_24),
        painterResource(id = R.drawable.ic_cam),
        painterResource(id = R.drawable.ic_ram),
        painterResource(id = R.drawable.ic_outline_sd_storage_24)
    )

    Row(
        modifier = modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        types.forEachIndexed { index, s ->
            Column(
                modifier = modifier
                    .width(80.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    modifier = Modifier.size(40.dp),
                    painter = icons[index],
                    contentDescription = null,
                    tint = Color.LightGray
                )
                Text(
//                modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    text = s.toString(),
                    style = Typography.labelSmall.copy(
                        color = Color.LightGray,
                        fontWeight = Light
                    )
                )

            }
        }
    }
}

@Composable
private fun ColorSelector(
    colors: ArrayList<String>,
    memory: ArrayList<String>,
    modifier: Modifier = Modifier
) {
    val selectedColorIndex = remember { mutableStateOf(0)}
    val selectedMemoryIndex = remember { mutableStateOf(0)}

    Column(
        modifier = modifier
    ) {
        Text(
            text = stringResource(R.string.details_select_color),
            style = Typography.labelMedium
        )
        Row(
            modifier = Modifier
            .fillMaxWidth()
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(0.5f)
            ) {
                colors.forEachIndexed { index, s ->
                    Surface(
                        modifier = Modifier
                            .size(50.dp)
                            .padding(8.dp)
                            .clickable {
                                selectedColorIndex.value = index
                            },
                        shape = CircleShape,
                        color = Color(colors[index].toColorInt())
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.Done,
                            contentDescription = null,
                            tint = if(selectedColorIndex.value == index) Color.White else Color.Transparent,
                            modifier = Modifier
                                .padding(5.dp)
                                .size(40.dp)
                        )
                    }
                }
            }
            Row (
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ){
                memory.forEachIndexed { index, s ->
                    Surface(
                        modifier = Modifier
                            .height(50.dp)
                            .width(80.dp)
                            .padding(8.dp)
                            .clickable {
                                selectedMemoryIndex.value = index
                            },
                        shape = RoundedCornerShape(10.dp),
                        color = if(selectedMemoryIndex.value == index) colorResource(id = R.color.main)
                                else Color.White
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceAround
                        ) {
                            Text(
                                text = "$s GB",
                                style = Typography.labelSmall.copy(
                                    color = if(selectedMemoryIndex.value == index) Color.White
                                    else Color.Gray
                                )
                            )
                        }
                    }
                }
            }
        }
    }

}

@Composable
private fun AddToCart(price: String = "", modifier: Modifier = Modifier) {
    Button(
        onClick = { /*TODO*/ },
        shape = RoundedCornerShape(10.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = colorResource(id = R.color.main),
            contentColor = Color.White
        ),
        modifier = modifier
            .fillMaxWidth()
            .height(50.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            Text(
                text = stringResource(id = R.string.details_add_to_cart),
                style = Typography.labelLarge
            )
            Text(
                text = "$$price",
                style = Typography.labelLarge
            )
        }
    }
}
