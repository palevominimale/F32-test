package app.seals.f32test.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import app.seals.f32test.main.vm.MainActivityViewModel
import app.seals.f32test.ui.navigation.NavigationGraph
import app.seals.f32test.ui.screens.main.BottomBar
import app.seals.f32test.ui.screens.splash.SplashScreen
import app.seals.f32test.ui.states.UiState
import app.seals.f32test.ui.theme.F32TestTheme
import org.koin.androidx.viewmodel.ext.android.viewModel

@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {
    private val vm : MainActivityViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        vm.getData()
        setContent {
            F32TestTheme {
                val navController = rememberNavController()
                val state by vm.state.collectAsState()
                Scaffold(
                    bottomBar = {
                        if(state is UiState.MainReady) BottomBar(navController = navController)
                    }
                ) {
                    Surface(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(it)
                    ) {
                        if(vm.state.value is UiState.Splash) SplashScreen()
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