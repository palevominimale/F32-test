package app.seals.f32test.ui.screens.main

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import app.seals.f32test.R
import app.seals.f32test.ui.main.vm.MainActivityViewModel
import app.seals.f32test.ui.models.BestSellerItemModel
import app.seals.f32test.ui.sampledata.DataPump
import app.seals.f32test.ui.states.UiState
import app.seals.f32test.ui.theme.Typography
import coil.compose.AsyncImage

@Composable
fun BestSeller(
    list: List<BestSellerItemModel>,
    onSelect: (Int) -> Unit
) {
    val width = LocalConfiguration.current.screenWidthDp
    val height = ((width/1.5+17)*(list.size/2 + list.size%2)).dp

    Column {
        Text(
            text = stringResource(id = R.string.main_best_seller),
            modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 16.dp),
            style = Typography.bodyLarge
        )
        LazyVerticalGrid(
            userScrollEnabled = false,
            modifier = Modifier
                .height(height),
            columns = GridCells.Fixed(2),
        ) {
            itemsIndexed(list) { _, item ->
                BestSellerItemView(
                    item = item,
                    height = (width/1.5).dp,
                    onSelect = { onSelect(it) }
                )
            }
        }
    }
}

@Composable
private fun BestSellerItemView(
    item: BestSellerItemModel,
    height: Dp,
    onSelect: (Int) -> Unit
) {
    var hMeasured = height
    val density = LocalDensity.current
    val interactionSource = MutableInteractionSource()
    Column(
        modifier = Modifier
            .padding(8.dp)
            .clickable(
                indication = null,
                interactionSource = interactionSource
            ) {
                onSelect(item.id ?: 0)
            }
                    .fillMaxSize()
            .height(height)
            .shadow(
                elevation = 2.dp,
                shape = RoundedCornerShape(16.dp)
            )
            .background(
                color = Color.White,
                shape = RoundedCornerShape(16.dp)
            )
            .onGloballyPositioned {
                hMeasured = with(density) { it.size.height.toDp() }
            },
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        Box(
            contentAlignment = Alignment.TopEnd,
        ) {
            LabelFavorite(item.isFavorites ?: false)
            AsyncImage(
                model = item.picture,
                contentDescription = "",
                modifier = Modifier
                    .clip(RoundedCornerShape(16.dp))
                    .height(hMeasured-46.dp)
                    .fillMaxWidth(),
                contentScale = ContentScale.Crop)
        }

        Row (
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .background(color = Color.White)
                .fillMaxWidth()
                .padding(horizontal = 8.dp)
        ) {
            Text(
                modifier = Modifier.padding(end = 4.dp),
                text = "$${item.priceWithoutDiscount.toString()}",
                style = Typography.labelMedium
            )
            Text(
                text = "$${item.discountPrice.toString()}",
                style = Typography.labelSmall.copy(color = Color.Gray)
            )
        }
        Text(
            text = item.title.toString(),
            style = Typography.labelMedium.copy(fontWeight = FontWeight.Thin),
            overflow = TextOverflow.Ellipsis,
            maxLines = 1,
            modifier = Modifier
                .background(color = Color.White)
                .fillMaxWidth()
                .padding(start = 8.dp, end = 8.dp, bottom = 8.dp)
        )
    }
}

@Composable
private fun LabelFavorite(
    isFavorite: Boolean
) {
    Box(modifier = Modifier
        .padding(16.dp)
        .size(28.dp)
        .shadow(3.dp, shape = CircleShape)
        .background(color = colorResource(R.color.white))
        .zIndex(2f),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            modifier = Modifier.padding(6.dp),
            painter = painterResource(id =
                if(isFavorite) R.drawable.ic_baseline_favorite_24
                else R.drawable.ic_baseline_favorite_border_24),
            contentDescription = null,
            tint = colorResource(id = R.color.main)
        )
    }
}