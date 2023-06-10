package ru.kiruxadance.feature_cars_list.domain.model

data class Car(
    val id: Int,
    val image: String,
    val images: List<Image>,
    val name: String,
    val year: Int
)
