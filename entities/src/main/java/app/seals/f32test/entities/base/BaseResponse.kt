package app.seals.f32test.entities.base

data class BaseResponse (
    var homeStore  : ArrayList<HomeStoreItemModel>  = arrayListOf(),
    var bestSeller : ArrayList<BestSellerItemModel> = arrayListOf()
)