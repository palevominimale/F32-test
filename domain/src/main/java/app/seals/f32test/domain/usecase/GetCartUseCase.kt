package app.seals.f32test.domain.usecase

import app.seals.f32test.domain.repos.RemoteApi
import app.seals.f32test.entities.api.ApiResult

class GetCartUseCase(
    private val repo: RemoteApi
) {
    suspend fun execute() : ApiResult {
        return repo.getCart()
    }
}