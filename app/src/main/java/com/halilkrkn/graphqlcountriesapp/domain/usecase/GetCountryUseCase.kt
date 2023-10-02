package com.halilkrkn.graphqlcountriesapp.domain.usecase

import com.halilkrkn.graphqlcountriesapp.domain.model.DetailedCountry
import com.halilkrkn.graphqlcountriesapp.domain.model.SimpleCountry
import com.halilkrkn.graphqlcountriesapp.domain.repository.CountryClientRepository

class GetCountryUseCase(
    private val countryClientRepository: CountryClientRepository,
) {
    suspend fun execute(code: String): DetailedCountry? {
        return countryClientRepository
            .getCountry(code)
    }
}