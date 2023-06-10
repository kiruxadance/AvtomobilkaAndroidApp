package ru.kiruxadance.feature_car_details.presentation.screen

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import ru.kiruxadance.core.common.Resource
import ru.kiruxadance.feature_car_details.domain.use_cases.GetCarDetailsUseCase
import ru.kiruxadance.feature_car_details.domain.use_cases.GetCarPostsUseCase
import javax.inject.Inject

@HiltViewModel
class CarDetailsViewModel @Inject constructor(
    private val getCarDetailsUseCase: GetCarDetailsUseCase,
    private val getCarPostsUseCase: GetCarPostsUseCase,
    savedStateHandle: SavedStateHandle
): ViewModel() {

    private val _carDetails = mutableStateOf(CarDetailsStateHolder())
    val carDetails: State<CarDetailsStateHolder> get() = _carDetails

    private val _carPosts = mutableStateOf(CarPostsStateHolder())
    val carPosts: State<CarPostsStateHolder> get() = _carPosts

    init {
        savedStateHandle.getLiveData<String>("id").observeForever {
            it?.let {
                getCarDetails(it)
                getCarPosts(it)
            }
        }
    }

    private fun getCarDetails(id: String) = viewModelScope.launch {
        getCarDetailsUseCase(id).onEach {
            when(it) {
                is Resource.Error -> {
                    _carDetails.value = CarDetailsStateHolder(error = it.message.toString())
                }
                is Resource.Loading -> {
                    _carDetails.value = CarDetailsStateHolder(isLoading = true)
                }
                is Resource.Success -> {
                    _carDetails.value = CarDetailsStateHolder(data = it.data)
                }
            }
        }.launchIn(viewModelScope)
    }

    private fun getCarPosts(id: String) = viewModelScope.launch {
        getCarPostsUseCase(id).onEach {
            when(it) {
                is Resource.Error -> {
                    _carPosts.value = CarPostsStateHolder(error = it.message.toString())
                }
                is Resource.Loading -> {
                    _carPosts.value = CarPostsStateHolder(isLoading = true)
                }
                is Resource.Success -> {
                    _carPosts.value = CarPostsStateHolder(data = it.data)
                }
            }
        }.launchIn(viewModelScope)
    }
}