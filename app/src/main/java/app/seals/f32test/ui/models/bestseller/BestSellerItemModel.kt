package app.seals.f32test.ui.models.bestseller

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class BestSellerItemModel (

    @SerializedName("id"                     ) var id                   : Int?     = null,
    @SerializedName("is_favorites"           ) var isFavorites          : Boolean? = null,
    @SerializedName("title"                  ) var title                : String?  = null,
    @SerializedName("price_without_discount" ) var priceWithoutDiscount : Int?     = null,
    @SerializedName("discount_price"         ) var discountPrice        : Int?     = null,
    @SerializedName("picture"                ) var picture              : String?  = null

) : Serializable