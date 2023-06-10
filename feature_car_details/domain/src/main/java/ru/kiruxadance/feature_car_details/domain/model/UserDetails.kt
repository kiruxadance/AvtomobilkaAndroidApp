package ru.kiruxadance.feature_car_details.domain.model

data class UserDetails(
    val about: String,
    val auto_count: Int,
    val avatar: Avatar,
    val email: String,
    val id: Int,
    val main_auto_name: String,
    val username: String
)
