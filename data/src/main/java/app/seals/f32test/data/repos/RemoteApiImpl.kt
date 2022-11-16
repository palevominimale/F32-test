package app.seals.f32test.data.repos

import app.seals.f32test.data.repos.api.ApiHandler.handleApi
import app.seals.f32test.data.repos.api.ApiRequest
import app.seals.f32test.domain.repos.RemoteApi
import app.seals.f32test.entities.api.ApiResult
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RemoteApiImpl : RemoteApi {

    private val retrofit: ApiRequest by lazy {
        Retrofit.Builder()
            .baseUrl(ApiRequest.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiRequest::class.java)
    }

    override suspend fun getDetails(id: Int): ApiResult {
        return execute { retrofit.getDetails() }
    }

    override suspend fun getMain(): ApiResult {
        return execute { retrofit.getMain() }
    }

    override suspend fun getCart(): ApiResult {
        return execute { retrofit.getCart() }
    }

    private suspend fun execute(request: () -> Call<*>) : ApiResult {
        return when(val res = handleApi { request.invoke().execute() } ) {
            is ApiResult.ApiSuccess -> ApiResult.ApiSuccess(data = res.data)
            is ApiResult.ApiError -> ApiResult.ApiError(code = res.code, message = res.message)
            is ApiResult.ApiException -> ApiResult.ApiException(e = res.e)
            else -> {ApiResult.ApiError()}
        }
    }

}