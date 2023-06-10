package ru.kiruxadance.feature_car_details.domain.use_cases

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import ru.kiruxadance.core.common.Resource
import ru.kiruxadance.feature_car_details.domain.repository.CarDetailsRepository
import javax.inject.Inject

class GetCarPostsUseCase @Inject constructor(
    private val carDetailsRepository: CarDetailsRepository
){
    operator fun invoke(id: String) = flow {
        emit(Resource.Loading())
        emit(Resource.Success(carDetailsRepository.getCarPosts(id)))
    }.catch {
        emit(Resource.Error(it.message.toString()))
    }.flowOn(Dispatchers.IO)
}