package app.seals.f32test.entities.base

import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class HomeStoreItemModel (
    @SerializedName("id")           var id       : Int?     = null,
    @SerializedName("is_new")        var isNew    : Boolean? = null,
    @SerializedName("title")        var title    : String?  = null,
    @SerializedName("subtitle")     var subtitle : String?  = null,
    @SerializedName("picture")      var picture  : String?  = null,
    @SerializedName("is_buy")        var isBuy    : Boolean? = null
) : Serializable