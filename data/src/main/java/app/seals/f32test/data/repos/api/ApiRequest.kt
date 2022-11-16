package app.seals.f32test.data.repos.api

import app.seals.f32test.entities.DetailsModel
import app.seals.f32test.entities.base.BaseResponse
import app.seals.f32test.entities.cart.CartResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiRequest {

    @GET("654bd15e-b121-49ba-a588-960956b15175")
    fun getMain() : Call<BaseResponse>

    @GET("6c14c560-15c6-4248-b9d2-b4508df7d4f5")
    fun getDetails() : Call<DetailsModel>

    @GET("53539a72-3c5f-4f30-bbb1-6ca10d42c149")
    fun getCart() : Call<CartResponse>

    companion object {
        const val BASE_URL = """https://run.mocky.io/v3/"""
    }

}