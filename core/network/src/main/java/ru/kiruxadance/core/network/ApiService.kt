package ru.kiruxadance.core.network

import retrofit2.http.GET
import retrofit2.http.Path
import ru.kiruxadance.core.network.model.CarDetailsResponse
import ru.kiruxadance.core.network.model.CarsListResponse
import ru.kiruxadance.core.network.model.CarsPostsResponse

interface ApiService {

    @GET("api/v1/cars/list")
    suspend fun getCars(): CarsListResponse

    @GET("api/v1/car/{id}")
    suspend fun getCarDetails(@Path("id") id: String): CarDetailsResponse

    @GET("api/v1/car/{id}/posts")
    suspend fun getCarPosts(@Path("id") id: String) : CarsPostsResponse
}