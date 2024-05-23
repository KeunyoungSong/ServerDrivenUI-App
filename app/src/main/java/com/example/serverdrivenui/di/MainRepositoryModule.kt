package com.example.serverdrivenui.di

import com.example.serverdrivenui.remote.MainService
import com.example.serverdrivenui.repository.MainRepository
import com.example.serverdrivenui.repository.MainRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object MainRepositoryModule {

    @ViewModelScoped
    @Provides
    fun providesMainRepository(
        mainService: MainService
    ): MainRepository = MainRepositoryImpl(mainService)
}