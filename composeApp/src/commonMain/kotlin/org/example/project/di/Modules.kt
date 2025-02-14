package org.example.project.di

import org.example.project.Weather.data.repository.WeatherRepositoryImp
import org.example.project.Weather.domain.repository.WeatherRepository
import org.example.project.Weather.presentation.WeatherViewModel
import org.example.project.core.HttpClientFactory
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module

expect val platformModule: Module

val sharedModule = module {
    single { HttpClientFactory.create(get()) }
    singleOf(::WeatherRepositoryImp).bind<WeatherRepository>()

    viewModelOf(::WeatherViewModel)
}