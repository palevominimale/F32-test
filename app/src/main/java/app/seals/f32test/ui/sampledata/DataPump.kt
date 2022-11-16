package app.seals.f32test.ui.sampledata

import android.annotation.SuppressLint
import app.seals.f32test.R
import app.seals.f32test.ui.main.vm.MainActivityViewModel
import app.seals.f32test.ui.states.UiState
import app.seals.f32test.entities.DetailsModel
import app.seals.f32test.entities.base.BaseResponse
import app.seals.f32test.entities.base.BestSellerItemModel
import app.seals.f32test.entities.base.HomeStoreItemModel
import app.seals.f32test.entities.cart.CartItem
import app.seals.f32test.entities.cart.CartResponse
import app.seals.f32test.ui.screens.CategoryItemModel
import kotlinx.coroutines.flow.MutableStateFlow

object DataPump {
    private val listOfCategories = listOf(
        CategoryItemModel("Phones", R.drawable.ic_outline_phone_iphone_24, selected = true),
        CategoryItemModel("Computer", R.drawable.ic_baseline_computer_24, selected = false),
        CategoryItemModel("Health", R.drawable.ic_baseline_health_and_safety_24, selected = false),
        CategoryItemModel("Books", R.drawable.ic_baseline_library_books_24, selected = false),
        CategoryItemModel("Hearts", R.drawable.ic_baseline_favorite_border_24, selected = false)
    )

    private val listOfHotSales = arrayListOf(
        HomeStoreItemModel(
            id = 1,
            isNew = true,
            title = "Iphone 12",
            subtitle = "Súper. Mega. Rápido.",
            picture = "https://img.ibxk.com.br/2020/09/23/23104013057475.jpg?w=1120&h=420&mode=crop&scale=both",
            isBuy = true
        ),
        HomeStoreItemModel(
            id = 2,
            isNew = false,
            title = "Samsung Galaxy A71",
            subtitle = "Súper. Mega. Rápido.",
            picture = "https://cdn-2.tstatic.net/kupang/foto/bank/images/pre-order-samsung-galaxy-a71-laris-manis-inilah-rekomendasi-ponsel-harga-rp-6-jutaan.jpg",
            isBuy = true
        ),
        HomeStoreItemModel(
            id = 3,
            isNew = false,
            title = "Xiaomi Mi 11 ultra",
            subtitle = "Súper. Mega. Rápido.",
            picture = "https://static.digit.in/default/942998b8b4d3554a6259aeb1a0124384dbe0d4d5.jpeg",
            isBuy = true
        ),
    )
    private val listOfBestSellers = arrayListOf(
        BestSellerItemModel(
            id = 111,
            isFavorites = false,
            title = "Samsung Galaxy s20 Ultra",
            priceWithoutDiscount = 1047,
            discountPrice = 1500,
            picture = "https://shop.gadgetufa.ru/images/upload/52534-smartfon-samsung-galaxy-s20-ultra-12-128-chernyj_1024.jpg"
        ),
        BestSellerItemModel(
            id = 222,
            isFavorites = true,
            title = "Xiaomi Mi 10 Pro",
            priceWithoutDiscount = 300,
            discountPrice = 400,
            picture = "https://mi92.ru/wp-content/uploads/2020/03/smartfon-xiaomi-mi-10-pro-12-256gb-global-version-starry-blue-sinij-1.jpg"
        ),
        BestSellerItemModel(
            id = 3333,
            isFavorites = true,
            title = "Samsung Note 20 Ultra",
            priceWithoutDiscount = 1047,
            discountPrice = 1500,
            picture = "https://mi92.ru/wp-content/uploads/2020/03/smartfon-xiaomi-mi-10-pro-12-256gb-global-version-starry-blue-sinij-1.jpg"
            //doesn't loading picture = "https://opt-1739925.ssl.1c-bitrix-cdn.ru/upload/iblock/c01/c014d088c28d45b606ed8c58e5817172.jpg?160405904823488"
        ),
        BestSellerItemModel(
            id = 4444,
            isFavorites = true,
            title = "Motorola One Edge",
            priceWithoutDiscount = 300,
            discountPrice = 400,
            picture = "https://www.benchmark.rs/assets/img/news/edge1.jpg"
        ),
        BestSellerItemModel(
            id = 55,
            isFavorites = false,
            title = "Samsung Galaxy s20 Ultra",
            priceWithoutDiscount = 1047,
            discountPrice = 1500,
            picture = "https://shop.gadgetufa.ru/images/upload/52534-smartfon-samsung-galaxy-s20-ultra-12-128-chernyj_1024.jpg"
        ),
        BestSellerItemModel(
            id = 66,
            isFavorites = true,
            title = "Xiaomi Mi 10 Pro",
            priceWithoutDiscount = 300,
            discountPrice = 400,
            picture = "https://mi92.ru/wp-content/uploads/2020/03/smartfon-xiaomi-mi-10-pro-12-256gb-global-version-starry-blue-sinij-1.jpg"
        ),
        BestSellerItemModel(
            id = 77,
            isFavorites = true,
            title = "Samsung Note 20 Ultra",
            priceWithoutDiscount = 1047,
            discountPrice = 1500,
            picture = "https://mi92.ru/wp-content/uploads/2020/03/smartfon-xiaomi-mi-10-pro-12-256gb-global-version-starry-blue-sinij-1.jpg"
            //doesn't loading picture = "https://opt-1739925.ssl.1c-bitrix-cdn.ru/upload/iblock/c01/c014d088c28d45b606ed8c58e5817172.jpg?160405904823488"
        ),
    )

    val state = UiState.MainReady(
        categories = listOfCategories,
        apiResponse = BaseResponse(
            homeStore = listOfHotSales,
            bestSeller = listOfBestSellers
        )
    )

    val vm = @SuppressLint("StaticFieldLeak")
    object : MainActivityViewModel() {
        override val state = MutableStateFlow<UiState>(this@DataPump.state)
    }

    val detailsModel = DetailsModel(
        CPU = "Exynos 990",
        camera = "108 + 12 mp",
        capacity = arrayListOf(
            "128",
            "256"
        ),
        color = arrayListOf(
            "#772D03",
            "#010035"
        ),
        id = "3",
        images = arrayListOf(
            "https://avatars.mds.yandex.net/get-mpic/5235334/img_id5575010630545284324.png/orig",
            "https://www.manualspdf.ru/thumbs/products/l/1260237-samsung-galaxy-note-20-ultra.jpg"
        ),
        isFavorites = true,
        price = 1500,
        rating = 2.5,
        sd = "256 GB",
        ssd = "8 GB",
        title = "Galaxy Note 20 Ultra"
    )

    val stateDetails = UiState.DetailsReady(
        item = detailsModel
    )

    val cartResponse = CartResponse(
        basket = arrayListOf(
            CartItem(
                id = 1,
                images = "https://www.manualspdf.ru/thumbs/products/l/1260237-samsung-galaxy-note-20-ultra.jpg",
                price = 1500,
                title = "Galaxy Note 20 Ultra",
            ),
            CartItem(
                id = 2,
                images = "https://store.storeimages.cdn-apple.com/4668/as-images.apple.com/is/iphone-13-pro-silver-select?wid=470&hei=556&fmt=jpeg&qlt=95&.v=1631652954000",
                price = 1800,
                title = "iPhone 13",
            ),
        ),
        delivery = "Free",
        id = "4",
        total = 3300
    )

    val stateCart = UiState.CartReady(
        cart = cartResponse
    )
}