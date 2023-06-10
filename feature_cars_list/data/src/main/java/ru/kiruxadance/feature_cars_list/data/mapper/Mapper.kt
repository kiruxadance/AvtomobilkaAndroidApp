package ru.kiruxadance.feature_cars_list.data.mapper

import ru.kiruxadance.core.network.model.CarsListResponse
import ru.kiruxadance.core.network.model.ImageDto
import ru.kiruxadance.feature_cars_list.domain.model.Car
import ru.kiruxadance.feature_cars_list.domain.model.Image

fun CarsListResponse.toDomainCars(): List<Car> {
    return this.map {
        Car(
            id = it.id,
            image = it.image,
            images = it.images.toDomainImages(),
            name = it.name,
            year = it.year
        )
    }
}

fun List<ImageDto>.toDomainImages(): List<Image> {
    return this.map {
        Image(
            id = it.id,
            image100 = it.image100,
            image500 = it.image500,
            index = it.index,
            is_primary = it.is_primary,
            size = it.size,
            thumbnail_url = it.thumbnail_url,
            url = it.url,
        )
    }
}