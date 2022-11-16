package app.seals.f32test.di

import app.seals.f32test.data.repos.RemoteApiImpl
import app.seals.f32test.domain.repos.RemoteApi
import org.koin.dsl.module

val dataDi = module {
    single <RemoteApi> {
        RemoteApiImpl()
    }
}