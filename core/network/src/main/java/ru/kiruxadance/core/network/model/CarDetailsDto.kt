package ru.kiruxadance.core.network.model

data class CarDetailsDto(
    val brand_id: Int,
    val brand_name: String,
    val city_name: String,
    val country_name: String,
    val engine: String,
    val engine_id: Int,
    val engine_name: String,
    val engine_volume: String,
    val follow: Boolean,
    val followers_count: Int,
    val for_sale: Int,
    val id: Int,
    val images: List<ImageDto>,
    val in_selection_count: Int,
    val is_moderated: Boolean,
    val model_id: Int,
    val model_name: String,
    val name: String,
    val place_id: String,
    val place_name: String,
    val price: Any,
    val transmission_id: Int,
    val transmission_name: String,
    val year: Int
)