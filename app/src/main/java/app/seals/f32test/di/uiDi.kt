package app.seals.f32test.di

import app.seals.f32test.ui.main.MainActivityViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val uiDi = module {
    viewModel {
        MainActivityViewModel()
    }
}