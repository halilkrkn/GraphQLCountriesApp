package com.halilkrkn.graphqlcountriesapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.halilkrkn.graphqlcountriesapp.domain.usecase.GetCountriesUseCase
import com.halilkrkn.graphqlcountriesapp.domain.usecase.GetCountryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class CountriesViewModel @Inject constructor(
    private val getCountriesUseCase: GetCountriesUseCase,
    private val getCountryUseCase: GetCountryUseCase,
) : ViewModel() {

    private val _state = MutableStateFlow(CountriesState())
    val state: StateFlow<CountriesState> = _state.asStateFlow()

    init {
        viewModelScope.launch {
            _state.update { countryState ->
                countryState.copy(isLoading = true)
            }
            _state.update { countryState ->
                countryState.copy(
                    countries = getCountriesUseCase.execute(),
                    isLoading = false
                )
            }
        }
    }

    fun selectCountry(code:String) {
        viewModelScope.launch {
            _state.update { countryState ->
                countryState.copy(
                    selectedCountry = getCountryUseCase.execute(code),
                )
            }
        }
    }

    fun dismissCountryDialog() {
        _state.update { countriesState ->
            countriesState.copy(
                selectedCountry = null
            )
        }
    }
}

