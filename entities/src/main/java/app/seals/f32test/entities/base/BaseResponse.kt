package app.seals.f32test.entities.base

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class BaseResponse (
    @SerializedName("home_store")        var homeStore  : ArrayList<HomeStoreItemModel>  = arrayListOf(),
    @SerializedName("best_seller")       var bestSeller : ArrayList<BestSellerItemModel> = arrayListOf()
) : Serializable