package com.halilkrkn.graphqlcountriesapp.data.mapper

import com.halilkrkn.CountriesQuery
import com.halilkrkn.CountryQuery
import com.halilkrkn.graphqlcountriesapp.domain.model.DetailedCountry
import com.halilkrkn.graphqlcountriesapp.domain.model.SimpleCountry

fun CountryQuery.Country.toDetailedCountry(): DetailedCountry {
return DetailedCountry(
        code = code,
        name = name,
        capital = capital ?: "No Capital",
        emoji = emoji,
        currency = currency ?: "No Currency",
        languages = languages.mapNotNull { it.name },
        continent = continent.name
    )
}

fun CountriesQuery.Country.toSimpleCountry(): SimpleCountry {
    return SimpleCountry(
        code = code,
        name = name,
        emoji = emoji,
        capital = capital ?: "No Capital"
    )
}