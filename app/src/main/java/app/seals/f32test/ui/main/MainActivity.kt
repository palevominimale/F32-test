@file:OptIn(ExperimentalMaterial3Api::class)

package app.seals.f32test.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import app.seals.f32test.ui.main.vm.MainActivityViewModel
import app.seals.f32test.ui.navigation.NavigationGraph
import app.seals.f32test.ui.sampledata.DataPump
import app.seals.f32test.ui.screens.main.MainScreen
import app.seals.f32test.ui.screens.main.bottombar.BottomBar
import app.seals.f32test.ui.theme.F32TestTheme
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {
    private val vm : MainActivityViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vm.getData()
        setContent {
            F32TestTheme {
                val navController = rememberNavController()
                Scaffold(
                    bottomBar = { BottomBar(vm) }
                ) {
                    Surface(
                        modifier = Modifier
                        .fillMaxSize()
                        .padding(it)
                    ) {
                        NavigationGraph(
                            navController = navController,
                            vm = vm
                        )
                    }
                }
            }
        }
    }
}