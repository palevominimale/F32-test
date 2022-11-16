package app.seals.f32test.entities.base

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class BestSellerItemModel (
    @SerializedName("id")                       var id                   : Int?     = null,
    @SerializedName("isFavorites")              var isFavorites          : Boolean? = null,
    @SerializedName("title")                    var title                : String?  = null,
    @SerializedName("priceWithoutDiscount")     var priceWithoutDiscount : Int?     = null,
    @SerializedName("discountPrice")            var discountPrice        : Int?     = null,
    @SerializedName("picture")                  var picture              : String?  = null
) : Serializable