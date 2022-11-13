package app.seals.f32test.ui.screens.main

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import app.seals.f32test.R
import app.seals.f32test.ui.theme.Typography

@Composable
fun LocationAndFilter( show: () -> Unit) {
    Box(
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp, top = 16.dp)
            .fillMaxWidth(),
        contentAlignment = Alignment.CenterEnd
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(
                modifier = Modifier.padding(end = 8.dp),
                painter = painterResource(id = R.drawable.ic_outline_location_on_24),
                tint = colorResource(id = R.color.main),
                contentDescription = null
            )
            Text(text = "Zihuatanejo, Gro", style = Typography.labelMedium)

            Icon(
                modifier = Modifier
                    .padding(start = 8.dp)
                    .size(16.dp),
                painter = painterResource(id = R.drawable.ic_outline_keyboard_arrow_down_24),
                tint = Color.LightGray,
                contentDescription = null
            )
        }
        Icon(
            modifier = Modifier
                .size(16.dp)
                .clickable {
                    show()
                },
            painter = painterResource(id = R.drawable.ic_outline_filter_alt_24),
            tint = Color.Black,
            contentDescription = null,
        )
    }
}