package app.seals.f32test.domain.repos

import app.seals.f32test.entities.api.ApiResult

interface RemoteApi {
    suspend fun getDetails(id: Int) : ApiResult
    suspend fun getMain() : ApiResult
    suspend fun getCart() : ApiResult
}