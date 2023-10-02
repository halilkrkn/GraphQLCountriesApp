package com.halilkrkn.graphqlcountriesapp.data.repository

import com.apollographql.apollo3.ApolloClient
import com.halilkrkn.CountriesQuery
import com.halilkrkn.CountryQuery
import com.halilkrkn.graphqlcountriesapp.data.mapper.toDetailedCountry
import com.halilkrkn.graphqlcountriesapp.data.mapper.toSimpleCountry
import com.halilkrkn.graphqlcountriesapp.domain.repository.CountryClientRepository
import com.halilkrkn.graphqlcountriesapp.domain.model.DetailedCountry
import com.halilkrkn.graphqlcountriesapp.domain.model.SimpleCountry
import javax.inject.Inject

class CountryClientRepositoryImpl @Inject constructor(
    private val apolloClient: ApolloClient
): CountryClientRepository {

    override suspend fun getCountries(): List<SimpleCountry> {
        return apolloClient
            .query(CountriesQuery())
            .execute()
            .data
            ?.countries
            ?.map {
                it.toSimpleCountry()
            }
            ?: emptyList()
    }

    override suspend fun getCountry(code: String): DetailedCountry? {
        return apolloClient
            .query(CountryQuery(code))
            .execute()
            .data
            ?.country
            ?.toDetailedCountry()
    }

}
