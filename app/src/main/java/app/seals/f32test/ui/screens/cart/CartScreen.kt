package app.seals.f32test.ui.screens.cart

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material.icons.outlined.KeyboardArrowLeft
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material.icons.sharp.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.seals.f32test.R
import app.seals.f32test.entities.cart.CartItem
import app.seals.f32test.entities.cart.CartResponse
import app.seals.f32test.ui.sampledata.DataPump
import app.seals.f32test.ui.theme.Typography
import coil.compose.AsyncImage

@Composable
@Preview
fun CartScreen(
    cart: CartResponse = DataPump.cartResponse,
    onDismiss: () -> Unit = {},
//    onLocation: () -> Unit = {},
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
            TopRow(
                onDismiss = { onDismiss() },
                onLocation = { onDismiss() }
            )

            CartContainer(cart = cart)

    }
}

@Composable
private fun TopRow(
    onDismiss: () -> Unit,
    onLocation: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
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
            text = stringResource(id = R.string.cart_add),
            style = Typography.labelMedium,
            textAlign = TextAlign.End,
            modifier = Modifier.fillMaxWidth(0.8f)
        )
        Button(
            modifier = Modifier
                .size(40.dp),
            contentPadding = PaddingValues(0.dp),
            onClick = { onLocation() },
            enabled = true,
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults
                .buttonColors(containerColor = colorResource(id = R.color.main))) {
            Icon(
                modifier = Modifier
                    .size(20.dp),
                imageVector = Icons.Outlined.LocationOn,
                tint = Color.White,
                contentDescription = null
            )
        }
    }
}

@Composable
private fun CartContainer(
    cart: CartResponse
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Text(
            modifier = Modifier.padding(vertical = 16.dp)
                .padding(16.dp),
            text = stringResource(R.string.cart_my),
            style = Typography.bodyLarge.copy(fontSize = 28.sp)
        )
        Surface(
            shape = RoundedCornerShape(30.dp),
            color = colorResource(id = R.color.secondary),
            modifier = Modifier
                .fillMaxSize()
        ) {
            Column (
                verticalArrangement = Arrangement.SpaceBetween
                    ) {
                LazyColumn {
                    cart.basket.forEach { item ->
                        item{ CartItem(item = item) }
                    }
                }
                Column {
                    Surface(
                        color = colorResource(id = R.color.quantity_background),
                        shape = RoundedCornerShape(2.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp)
                            .height(2.dp),
                        content = {}
                    )
                    val price = "$${cart.total} us"
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(
                                horizontal = 32.dp,
                                vertical = 16.dp
                            )
                    ) {
                        Column {
                            Text(
                                text = stringResource(id = R.string.cart_total),
                                style = Typography.labelMedium.copy(
                                    color = Color.White,
                                    fontWeight = FontWeight.Thin
                                )
                            )
                            Text(
                                text = stringResource(id = R.string.cart_delivery),
                                style = Typography.labelMedium.copy(
                                    color = Color.White,
                                    fontWeight = FontWeight.Thin
                                )
                            )
                        }
                        Column {
                            Text(
                                text = price,
                                style = Typography.labelMedium.copy(
                                    color = Color.White,
                                    fontWeight = FontWeight.Medium
                                )
                            )
                            Text(
                                text = cart.delivery.toString(),
                                style = Typography.labelMedium.copy(
                                    color = Color.White,
                                    fontWeight = FontWeight.Medium
                                )
                            )
                        }
                    }
                    Surface(
                        color = colorResource(id = R.color.quantity_background),
                        shape = RoundedCornerShape(2.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp)
                            .height(1.dp),
                        content = {}
                    )
                    Button(
                        onClick = { /*TODO*/ },
                        colors = ButtonDefaults.buttonColors(colorResource(R.color.main)),
                        shape = RoundedCornerShape(10.dp),
                        modifier = Modifier
                            .padding(start = 32.dp, end = 32.dp, bottom = 32.dp, top = 16.dp)
                            .height(50.dp)
                            .fillMaxWidth()
                    ) {
                        Text(
                            text = stringResource(R.string.cart_checkout),
                            textAlign = TextAlign.Center,
                            style = Typography.labelLarge.copy(
                                color = Color.White,
                                fontWeight = FontWeight.Medium
                            )
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun CartItem(item: CartItem) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp, top = 16.dp)
            .fillMaxWidth()
    ) {
        Row {
            AsyncImage(
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(80.dp)
                    .clip(RoundedCornerShape(20.dp)),
                model = item.images,
                contentDescription = null
            )
            Column(
                modifier = Modifier
                    .width(160.dp)
                    .padding(start = 8.dp)
            ) {
                Text(
                    text = item.title.toString(),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    style = Typography.labelLarge.copy(
                        color = Color.White,
                        fontWeight = FontWeight.Medium
                    )
                )
                Text(
                    text = "$${item.price}.00",
                    style = Typography.labelLarge.copy(
                        color = colorResource(id = R.color.main),
                        fontWeight = FontWeight.Medium
                    )
                )
            }
        }
            Surface(
                shape = RoundedCornerShape(14.dp),
                color = colorResource(R.color.quantity_background),
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(vertical = 4.dp)
                    .width(28.dp)
            ) {
            Column(
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(4.dp)
            ) {
                Text(
                    text = "—",
                    style = Typography.labelMedium.copy(color = Color.White),
                    modifier = Modifier.clickable(
                        indication = null,
                        interactionSource = MutableInteractionSource()
                    ) {

                    }
                )
                Text(
                    text = "1",
                    style = Typography.labelMedium.copy(color = Color.White)
                )
                Icon(
                    imageVector = Icons.Sharp.Add,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.clickable(
                        indication = null,
                        interactionSource = MutableInteractionSource()
                    ) {

                    }
                )
            }
        }
        Icon(
            imageVector = Icons.Outlined.Delete,
            contentDescription = null,
            tint = colorResource(R.color.quantity_background),
            modifier = Modifier
                .clickable(
                    indication = null,
                    interactionSource = MutableInteractionSource()
                ) {

                }
                .padding(horizontal = 8.dp)
                .size(20.dp)
        )
    }
}