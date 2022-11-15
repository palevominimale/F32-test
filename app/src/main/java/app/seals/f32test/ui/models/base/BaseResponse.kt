package app.seals.f32test.ui.models.base

import com.google.gson.annotations.SerializedName

data class BaseResponse (
    @SerializedName("home_store"  ) var homeStore  : ArrayList<HomeStoreItemModel>  = arrayListOf(),
    @SerializedName("best_seller" ) var bestSeller : ArrayList<BestSellerItemModel> = arrayListOf()
)