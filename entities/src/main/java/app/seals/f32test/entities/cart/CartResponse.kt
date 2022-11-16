package app.seals.f32test.entities.cart

data class CartResponse (
    var basket   : ArrayList<CartItem> = arrayListOf(),
    var delivery : String?             = null,
    var id       : String?             = null,
    var total    : Int?                = null
)