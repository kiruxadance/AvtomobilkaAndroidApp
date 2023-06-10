package ru.kiruxadance.feature_car_details.domain.model

data class Car(
    val follow: Boolean,
    val followers_count: Int,
    val id: Int,
    val images: List<Image>,
    val name: String,
    val year: Int
)
