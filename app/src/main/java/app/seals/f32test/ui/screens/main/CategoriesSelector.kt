@file:Suppress("UNCHECKED_CAST")

package app.seals.f32test.ui.screens.main

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import app.seals.f32test.R
import app.seals.f32test.ui.screens.CategoryItemModel
import app.seals.f32test.ui.theme.Typography
import com.google.accompanist.placeholder.placeholder

@Composable
fun CategoriesSelector(
    list: List<CategoryItemModel>,
    placeholders: Boolean = false
) {
    val selectedItem = remember { mutableStateOf(0) }
    Surface(
        modifier = Modifier.padding(vertical = 16.dp)
    ) {
        Column {
            Text(
                text = stringResource(id = R.string.main_select_category),
                modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 8.dp),
                style = Typography.bodyLarge
            )
            LazyRow {
                itemsIndexed(list) { index, it ->
                    CategoryItem(
                        item = it,
                        placeholders = placeholders,
                        selected = selectedItem.value == index,
                        select = {selectedItem.value = index}
                    )
                }
            }
        }

    }
}

@Composable
private fun CategoryItem(
    item: CategoryItemModel?,
    placeholders: Boolean,
    selected: Boolean,
    select: () -> Unit
) {
    val interactionSource = remember { MutableInteractionSource() }
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(PaddingValues(start = 16.dp, top = 8.dp))
            .clickable(
                indication = null,
                interactionSource = interactionSource
            ) { select() }
    ) {
        Box(modifier = Modifier
            .size(60.dp)
            .shadow(3.dp, shape = CircleShape)
            .placeholder(
                visible = placeholders,
                color = Color.LightGray
            )
            .background(color = colorResource(if (selected) R.color.main else R.color.white)),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                modifier = Modifier.size(30.dp),
                painter = painterResource(id = item?.icon ?: R.drawable.ic_baseline_close_24),
                contentDescription = item?.title ?: stringResource(id = R.string.category_null),
                tint = if (selected) Color.White else Color.LightGray
            )
        }
        val color = colorResource(id = if(selected) R.color.main else R.color.black)
        Text(
            modifier = Modifier.padding(vertical = 4.dp),
            text = item?.title ?: stringResource(id = R.string.category_null),
            style = Typography.labelSmall,
            color = color
        )
    }
}