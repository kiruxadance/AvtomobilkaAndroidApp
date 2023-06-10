package ru.kiruxadance.core.network.model

data class CarDetailsResponse(
    val car: CarDetailsDto,
    val user: UserDto
)