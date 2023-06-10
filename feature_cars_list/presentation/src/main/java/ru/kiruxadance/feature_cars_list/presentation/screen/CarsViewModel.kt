package ru.kiruxadance.feature_cars_list.presentation.screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import ru.kiruxadance.core.common.Resource
import ru.kiruxadance.feature_cars_list.domain.use_cases.GetCarsUseCase
import javax.inject.Inject

@HiltViewModel
class CarsViewModel @Inject constructor(
    private val getCarsUseCase: GetCarsUseCase
) : ViewModel() {
    private val _carsList = mutableStateOf(CarsStateHolder())
    val carsList: State<CarsStateHolder> get() = _carsList

    init {
        viewModelScope.launch {
            getCars()
        }
    }

    private fun getCars() = viewModelScope.launch {
        getCarsUseCase().onEach {
            when(it) {
                is Resource.Error -> {
                    _carsList.value = CarsStateHolder(error = it.message.toString())
                }
                is Resource.Loading -> {
                    _carsList.value = CarsStateHolder(isLoading = true)
                }
                is Resource.Success -> {
                    _carsList.value = CarsStateHolder(data = it.data)
                }
            }
        }.launchIn(viewModelScope)
    }
}