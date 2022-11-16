package app.seals.f32test.entities

data class DetailsModel (

    var CPU         : String?           = null,
    var camera      : String?           = null,
    var capacity    : ArrayList<String> = arrayListOf(),
    var color       : ArrayList<String> = arrayListOf(),
    var id          : String?           = null,
    var images      : ArrayList<String> = arrayListOf(),
    var isFavorites : Boolean?          = null,
    var price       : Int?              = null,
    var rating      : Double?           = null,
    var sd          : String?           = null,
    var ssd         : String?           = null,
    var title       : String?           = null

)