package app.seals.f32test.ui.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class DetailsModel (

    @SerializedName("CPU"         ) var CPU         : String?           = null,
    @SerializedName("camera"      ) var camera      : String?           = null,
    @SerializedName("capacity"    ) var capacity    : ArrayList<String> = arrayListOf(),
    @SerializedName("color"       ) var color       : ArrayList<String> = arrayListOf(),
    @SerializedName("id"          ) var id          : String?           = null,
    @SerializedName("images"      ) var images      : ArrayList<String> = arrayListOf(),
    @SerializedName("isFavorites" ) var isFavorites : Boolean?          = null,
    @SerializedName("price"       ) var price       : Int?              = null,
    @SerializedName("rating"      ) var rating      : Double?           = null,
    @SerializedName("sd"          ) var sd          : String?           = null,
    @SerializedName("ssd"         ) var ssd         : String?           = null,
    @SerializedName("title"       ) var title       : String?           = null

) : Serializable