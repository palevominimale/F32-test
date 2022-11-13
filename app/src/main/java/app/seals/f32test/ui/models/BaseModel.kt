package app.seals.f32test.ui.models

import app.seals.f32test.ui.models.hotsales.HomeStoreItemModel
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class BaseModel(
    @SerializedName("home_store"  ) var homeStore  : ArrayList<HomeStoreItemModel>  = arrayListOf(),
    @SerializedName("best_seller" ) var bestSeller : ArrayList<BestSellerItemModel> = arrayListOf()
) : Serializable
