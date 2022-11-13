package app.seals.f32test.ui.screens.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import app.seals.f32test.R
import app.seals.f32test.ui.theme.Typography

@Composable
@Preview
fun SearchField() {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .padding(horizontal = 16.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        CustomSearchField(
            modifier = Modifier
                .fillMaxHeight()
                .weight(1f)
                .shadow(
                    elevation = 5.dp,
                    shape = RoundedCornerShape(20.dp)
                )
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(20.dp)
                ),
            leadingIcon = {
                Icon(
                    modifier = Modifier.padding(end = 8.dp),
                    painter = rememberVectorPainter(Icons.Outlined.Search),
                    contentDescription = stringResource(id = R.string.search_text),
                    tint = colorResource(id = R.color.main)
                )
            },
            style = Typography.labelMedium
        )

        Surface(
            color = colorResource(id = R.color.main),
            modifier = Modifier
                .padding(start = 8.dp)
                .fillMaxHeight()
                .shadow(
                    elevation = 5.dp,
                    shape = CircleShape
                )
        ) {
            Icon(
                modifier = Modifier.padding(8.dp),
                painter = painterResource(id = R.drawable.ic_baseline_qr_code_24),
                contentDescription = stringResource(id = R.string.search_text),
                tint = Color.White
            )
        }
    }
}

@Composable
private fun CustomSearchField(
    modifier: Modifier = Modifier,
    leadingIcon: (@Composable () -> Unit)? = null,
    trailingIcon: (@Composable () -> Unit)? = null,
    placeholderText: String = stringResource(id = R.string.search_text),
    style: TextStyle = MaterialTheme.typography.labelMedium
) {

    var text by remember { mutableStateOf("") }

    BasicTextField(modifier = modifier,
        value = text,
        onValueChange = { text = it },
        singleLine = true,
        cursorBrush = SolidColor(MaterialTheme.colorScheme.primary),
        textStyle = style,
        decorationBox = { innerTextField ->
            Row(
                modifier.padding(start = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (leadingIcon != null) leadingIcon()
                Box(Modifier.weight(1f)) {
                    if (text.isEmpty()) Text(
                        placeholderText,
                        style = style
                    )
                    innerTextField()
                }
                if (trailingIcon != null) trailingIcon()
            }
        }
    )
}
