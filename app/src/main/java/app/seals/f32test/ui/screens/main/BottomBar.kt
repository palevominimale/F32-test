package app.seals.f32test.ui.screens.main

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import app.seals.f32test.R
import app.seals.f32test.ui.navigation.NavigationItem
import app.seals.f32test.ui.theme.Typography

@Composable
fun BottomBar(
    navController: NavController
) {
    Surface(
        shape = RoundedCornerShape(20.dp),
        color = colorResource(R.color.secondary),
        modifier = Modifier
            .fillMaxWidth()
            .zIndex(2f)
            .height(70.dp)
            .shadow(
                elevation = 10.dp,
                shape = RoundedCornerShape(20.dp),
            )

    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(vertical = 16.dp, horizontal = 32.dp)
        ) {
            NavBarExplorer { navController.navigate(NavigationItem.Home.route) }
            NavBarCart { navController.navigate(NavigationItem.Cart.route) }
            NavBarFavorite()
            NavBarUser()
        }
    }
}

@Composable
private fun NavBarCart(
    onNavigate: () -> Unit = {}
) {
    Box(
        modifier = Modifier.padding(horizontal = 20.dp)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_baseline_shopping_cart_24),
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier.clickable(
                indication = null,
                interactionSource = MutableInteractionSource()
            ) {
                onNavigate()
            }
        )
    }
}


@Composable
private fun NavBarFavorite(
    onNavigate: () -> Unit = {}
) {
    Box(
        modifier = Modifier.padding(horizontal = 20.dp)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_baseline_favorite_border_24),
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier.clickable(
                indication = null,
                interactionSource = MutableInteractionSource()
            ) {
                onNavigate()
            }
        )
    }
}

@Composable
private fun NavBarUser(
    onNavigate: () -> Unit = {}
) {
    Box(
        modifier = Modifier.padding(horizontal = 20.dp)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_baseline_person_outline_24),
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier.clickable(
                indication = null,
                interactionSource = MutableInteractionSource()
            ) {
                onNavigate()
            }
        )
    }
}


@Composable
private fun NavBarExplorer(
    onNavigate: () -> Unit = {}
) {
    Box(
        modifier = Modifier.padding(horizontal = 24.dp)
    ) {
        Text(
            text = "${kotlin.text.Typography.bullet} ${stringResource(id = R.string.bottom_explorer)}",
            style = Typography.labelMedium.copy(color = Color.White),
            modifier = Modifier.clickable(
                indication = null,
                interactionSource = MutableInteractionSource()
            ) {
                onNavigate()
            }
        )
    }
}