package app.seals.f32test.ui.screens.main.bestseller

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
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
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import app.seals.f32test.R
import app.seals.f32test.ui.main.vm.MainActivityViewModel
import app.seals.f32test.ui.models.bestseller.BestSellerItemModel
import app.seals.f32test.ui.states.UiState
import app.seals.f32test.ui.theme.Typography
import coil.compose.AsyncImage

@Composable
fun BestSeller(vm: MainActivityViewModel) {

    val state : UiState by vm.state.collectAsState()

    when(state) {
        is UiState.IsReady -> { BestSellerView((state as UiState.IsReady).bestSeller) }
        else -> {}
    }
}
@Composable
private fun BestSellerView(list: List<BestSellerItemModel>) {
    val state = rememberLazyGridState()
    val width = LocalConfiguration.current.screenWidthDp
    val height = (width/1.5*(list.size/2 + list.size%2)).dp
    Column {
        Text(
            text = stringResource(id = R.string.main_best_seller),
            modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 16.dp),
            style = Typography.bodyLarge
        )
        LazyVerticalGrid(
            state = state,
            userScrollEnabled = false,
            modifier = Modifier
                .height(height),
            columns = GridCells.Fixed(2),
        ) {
            itemsIndexed(list) { _, item ->
                BestSellerItemView(item, (width/1.7).dp)
            }
        }
    }
}

@Composable
private fun BestSellerItemView(item: BestSellerItemModel, height: Dp) {

    Column(
        modifier = Modifier
            .padding(8.dp)
            .height(height)
            .fillMaxSize()
            .shadow(
                elevation = 2.dp,
                shape = RoundedCornerShape(16.dp)
            )
            .background(
                color = Color.White,
                shape = RoundedCornerShape(16.dp)
            ),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        Box(
            contentAlignment = Alignment.TopEnd,
//            modifier = Modifier.height(height)
        ) {
            LabelFavorite(item.isFavorites ?: false)
            AsyncImage(
                model = item.picture,
                contentDescription = "",
                modifier = Modifier
                    .clip(RoundedCornerShape(16.dp))
                    .height(height-46.dp)
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
            style = Typography.labelMedium,
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
private fun LabelFavorite(isFavorite: Boolean) {
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