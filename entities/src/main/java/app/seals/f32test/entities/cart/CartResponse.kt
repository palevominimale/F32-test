package app.seals.f32test.entities.cart

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class CartResponse (
    @SerializedName("basket")       var basket   : ArrayList<CartItem> = arrayListOf(),
    @SerializedName("delivery")     var delivery : String?             = null,
    @SerializedName("id")           var id       : String?             = null,
    @SerializedName("total")        var total    : Int?                = null
) : Serializable