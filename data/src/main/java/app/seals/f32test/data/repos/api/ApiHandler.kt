package app.seals.f32test.data.repos.api

import app.seals.f32test.entities.api.ApiResult
import retrofit2.HttpException
import retrofit2.Response

object ApiHandler {
    fun <T: Any> handleApi(
        execute: () -> Response<T>
    ) : ApiResult {
        return try {
            val response = execute()
            val body = response.body()
            if(response.isSuccessful && body != null) {
                ApiResult.ApiSuccess(data = body)
            } else {
                ApiResult.ApiError(code = response.code(), message = response.message())
            }
        } catch (e: HttpException) {
            ApiResult.ApiError(code = e.code(), message = e.localizedMessage)
        } catch (e: Throwable) {
            ApiResult.ApiException(e)
        }
    }
}