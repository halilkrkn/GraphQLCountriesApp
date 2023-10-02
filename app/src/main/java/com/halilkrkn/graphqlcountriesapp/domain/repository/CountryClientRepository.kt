package com.halilkrkn.graphqlcountriesapp.domain.repository

import com.halilkrkn.graphqlcountriesapp.domain.model.DetailedCountry
import com.halilkrkn.graphqlcountriesapp.domain.model.SimpleCountry

interface CountryClientRepository {
    suspend fun getCountries(): List<SimpleCountry>
    suspend fun getCountry(code: String): DetailedCountry?
}