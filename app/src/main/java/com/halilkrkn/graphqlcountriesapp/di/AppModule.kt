package com.halilkrkn.graphqlcountriesapp.di

import com.apollographql.apollo3.ApolloClient
import com.halilkrkn.graphqlcountriesapp.data.repository.CountryClientRepositoryImpl
import com.halilkrkn.graphqlcountriesapp.domain.repository.CountryClientRepository
import com.halilkrkn.graphqlcountriesapp.domain.usecase.GetCountriesUseCase
import com.halilkrkn.graphqlcountriesapp.domain.usecase.GetCountryUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideApolloClient(): ApolloClient {
        return ApolloClient.builder()
            .serverUrl("https://countries.trevorblades.com/graphql")
            .build()
    }

    @Provides
    @Singleton
    fun provideCountryClientRepository(
        apolloClient: ApolloClient
    ): CountryClientRepository {
        return CountryClientRepositoryImpl(apolloClient)
    }

    @Provides
    @Singleton
    fun provideGetCountryUseCase(
        countryClientRepository: CountryClientRepository
    ): GetCountryUseCase {
        return GetCountryUseCase(countryClientRepository)
    }

    @Provides
    @Singleton
    fun provideGetCountriesUseCase(
        countryClientRepository: CountryClientRepository
    ): GetCountriesUseCase {
        return GetCountriesUseCase(countryClientRepository)
    }


}