package ru.kiruxadance.core.network.model

data class CarDto(
    val brand_id: Int,
    val brand_name: String,
    val city_name: String,
    val country_name: String,
    val engine: String,
    val engine_id: Int,
    val engine_name: String,
    val engine_volume: String,
    val for_sale: Int,
    val id: Int,
    val image: String,
    val images: List<ImageDto>,
    val model_id: Int,
    val model_name: String,
    val name: String,
    val place_id: String,
    val place_name: String,
    val price: Any,
    val thumbnail: String,
    val transmission_id: Int,
    val transmission_name: String,
    val year: Int
)