package app.seals.f32test.ui.screens.main.bottombar

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
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
import app.seals.f32test.R
import app.seals.f32test.ui.main.vm.MainActivityViewModel
import app.seals.f32test.ui.theme.Typography

@Composable
fun BottomBar(vm: MainActivityViewModel) {
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
            NavBarExplorer()
            NavBarCart()
            NavBarFavorite()
            NavBarUser()
        }
    }
}

@Composable
private fun NavBarCart() {
    Box(
        modifier = Modifier.padding(horizontal = 20.dp)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_baseline_shopping_cart_24),
            contentDescription = null,
            tint = Color.White
        )
    }
}


@Composable
private fun NavBarFavorite() {
    Box(
        modifier = Modifier.padding(horizontal = 20.dp)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_baseline_favorite_border_24),
            contentDescription = null,
            tint = Color.White
        )
    }
}

@Composable
private fun NavBarUser() {
    Box(
        modifier = Modifier.padding(horizontal = 20.dp)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_baseline_person_outline_24),
            contentDescription = null,
            tint = Color.White,
        )
    }
}


@Composable
private fun NavBarExplorer() {
    Box(
        modifier = Modifier.padding(horizontal = 24.dp)
    ) {
        Text(
            text = "${kotlin.text.Typography.bullet} ${stringResource(id = R.string.bottom_explorer)}",
            style = Typography.labelMedium.copy(color = Color.White)
        )
    }
}