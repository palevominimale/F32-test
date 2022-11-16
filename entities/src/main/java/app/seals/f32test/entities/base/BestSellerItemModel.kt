package app.seals.f32test.entities.base

data class BestSellerItemModel (
    var id                   : Int?     = null,
    var isFavorites          : Boolean? = null,
    var title                : String?  = null,
    var priceWithoutDiscount : Int?     = null,
    var discountPrice        : Int?     = null,
    var picture              : String?  = null
)