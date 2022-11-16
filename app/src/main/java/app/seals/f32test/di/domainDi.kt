package app.seals.f32test.di

import app.seals.f32test.domain.usecase.GetBaseDataUseCase
import app.seals.f32test.domain.usecase.GetCartUseCase
import app.seals.f32test.domain.usecase.GetSelectedDetailsUseCase
import org.koin.dsl.module

val domainDi = module {
    factory {
        GetBaseDataUseCase(
            repo = get()
        )
    }
    factory {
        GetSelectedDetailsUseCase(
            repo = get()
        )
    }
    factory {
        GetCartUseCase(
            repo = get()
        )
    }
}