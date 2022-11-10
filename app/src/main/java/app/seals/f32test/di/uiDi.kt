package app.seals.f32test.di

import app.seals.f32test.ui.main.vm.MainActivityViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val uiDi = module {
    viewModel {
        MainActivityViewModel()
    }
}