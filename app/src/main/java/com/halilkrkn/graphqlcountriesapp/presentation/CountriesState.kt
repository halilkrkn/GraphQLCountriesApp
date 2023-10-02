package com.halilkrkn.graphqlcountriesapp.presentation

import com.halilkrkn.graphqlcountriesapp.domain.model.DetailedCountry
import com.halilkrkn.graphqlcountriesapp.domain.model.SimpleCountry

data class CountriesState(
    val countries: List<SimpleCountry> = emptyList(),
    val isLoading: Boolean = false,
    val selectedCountry: DetailedCountry? = null,
)
