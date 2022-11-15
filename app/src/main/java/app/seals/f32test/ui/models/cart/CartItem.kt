package app.seals.f32test.ui.models.cart

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class CartItem (
    @SerializedName("id"     ) var id     : Int?    = null,
    @SerializedName("images" ) var images : String? = null,
    @SerializedName("price"  ) var price  : Int?    = null,
    @SerializedName("title"  ) var title  : String? = null

) : Serializable
