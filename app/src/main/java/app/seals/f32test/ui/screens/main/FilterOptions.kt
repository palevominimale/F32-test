package app.seals.f32test.ui.screens.main

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.toSize
import app.seals.f32test.R
import app.seals.f32test.ui.main.vm.MainActivityViewModel
import app.seals.f32test.ui.states.UiState
import app.seals.f32test.ui.theme.Typography

@Composable
fun FilterOptions(vm: MainActivityViewModel) {

    val state by vm.state.collectAsState()

    when(state) {
        is UiState.IsReady -> {
            if((state as UiState.IsReady).showFilter) FilterOptionsView()
        }
        else -> {}
    }
}

@Composable
@Preview
private fun FilterOptionsView() {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .shadow(
                elevation = 5.dp,
                shape = RoundedCornerShape(30.dp)
            )
            .background(
                color = Color.White,
                shape = RoundedCornerShape(30.dp)
            )
    ) {
        Column(
            modifier = Modifier.padding(start = 32.dp, end = 32.dp, top = 16.dp, bottom = 32.dp),
        ) {
            TopRow()
            Text(
                modifier = Modifier
                    .padding(top = 32.dp, bottom = 8.dp),
                text = stringResource(id = R.string.filter_brand),
                style = Typography.labelLarge
            )
            DropdownList(
                items = listOf(
                    "Apple",
                    "Samsung",
                    "Xiaomi"
                )
            )
            Text(
                modifier = Modifier
                    .padding(vertical = 8.dp),
                text = stringResource(id = R.string.filter_price),
                style = Typography.labelLarge
            )
            DropdownList(
                items = listOf(
                    "$100-$300",
                    "$300-$500",
                    "$500-$1000",
                    "$1000-$2000",
                    "$2000-$4000",
                    "$4000-$7000",
                    "$7000-$10000",
                )
            )
            Text(
                modifier = Modifier
                    .padding(vertical = 8.dp),
                text = stringResource(id = R.string.filter_size),
                style = Typography.labelLarge
            )
            DropdownList(
                items = listOf(
                    "3.5\" - 4.5\"",
                    "4.5\" - 5.0\"",
                    "5.0\" - 6.5\"",
                    "6.5\"+",
                )
            )
        }
    }
}

@Composable
private fun TopRow() {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Button(
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier
                .size(40.dp),
            contentPadding = PaddingValues(0.dp),
            onClick = { /*TODO*/ },
            colors = ButtonDefaults
                .buttonColors(containerColor = colorResource(id = R.color.secondary))
        ) {
            Icon(
                modifier = Modifier
                    .size(20.dp),
                painter = painterResource(id = R.drawable.ic_baseline_close_24),
                tint = Color.White,
                contentDescription = null
            )
        }
        Text(
            text = stringResource(id = R.string.filter_options),
            style = Typography.labelLarge
        )
        Button(
            modifier = Modifier
                .height(40.dp),
            onClick = { /*TODO*/ },
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults
                .buttonColors(containerColor = colorResource(id = R.color.main))) {
            Text(
                text = stringResource(id = R.string.filter_done),
                style = Typography.labelLarge
            )
        }
    }
}

@Composable
private fun DropdownList(
    modifier: Modifier = Modifier,
    style: TextStyle = MaterialTheme.typography.labelLarge.copy(fontWeight = FontWeight.Light),
    items: List<String>
) {

    var expanded by remember { mutableStateOf(false) }
    var selectedText by remember { mutableStateOf("") }
    var textFieldSize by remember { mutableStateOf(Size.Zero)}

    val icon =
        if (expanded) Icons.Filled.KeyboardArrowUp
        else Icons.Filled.ArrowDropDown

    Surface(
        shape = RoundedCornerShape(10.dp),
        color = Color.White,
        border = BorderStroke(1.dp, Color.LightGray)
    ) {
        Column(
            modifier = Modifier.padding(4.dp)
        ) {
            BasicTextField(modifier = modifier
                .onGloballyPositioned {
                    textFieldSize = it.size.toSize()
                },
                readOnly = true,
                value = selectedText,
                onValueChange = { selectedText = it },
                singleLine = true,
                cursorBrush = SolidColor(MaterialTheme.colorScheme.primary),
                textStyle = style,
                decorationBox = { innerTextField ->
                    Row(
                        modifier.padding(start = 8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(Modifier.weight(1f)) {
                            if (selectedText.isEmpty()) {
                                Text(
                                    text = items[0],
                                    style = style.copy(Color.LightGray)
                                )
                            }
                            innerTextField()
                        }
                        Icon(
                            imageVector = icon,
                            contentDescription = null,
                            modifier = Modifier
                                .clickable { expanded = !expanded }
                        )
                    }
                }
            )
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
                modifier = Modifier
                    .width(with(LocalDensity.current){textFieldSize.width.toDp()})
                    .background(color = Color.Unspecified, shape = RoundedCornerShape(20.dp))
            ) {
                items.forEach { label ->
                    DropdownMenuItem(text = { Text(text = label) },
                        onClick = {
                            selectedText = label
                            expanded = false
                        }
                    )
                }
            }
        }
    }
}