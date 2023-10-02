package com.halilkrkn.graphqlcountriesapp.domain.usecase

import com.halilkrkn.graphqlcountriesapp.domain.model.SimpleCountry
import com.halilkrkn.graphqlcountriesapp.domain.repository.CountryClientRepository

class GetCountriesUseCase(
    private val countryClientRepository: CountryClientRepository,
) {
    suspend fun execute(): List<SimpleCountry> {
        return countryClientRepository
            .getCountries()
            .sortedBy {simpleCountry ->
                simpleCountry.name
            }
    }

}