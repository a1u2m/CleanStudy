package com.example.kiparomvvm.di

import android.content.Context
import com.example.kiparomvvm.domain.usecase.GetUserNameUseCase
import com.example.kiparomvvm.domain.usecase.SaveUserNameUseCase
import com.example.kiparomvvm.presentation.MainViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class AppModule(private val context: Context) {

    @Provides
    fun provideContext(): Context {
        return context
    }

    @Provides
    fun provideMainViewModelFactory(
        getUserNameUseCase: GetUserNameUseCase,
        saveUserNameUseCase: SaveUserNameUseCase
    ): MainViewModelFactory {
        return MainViewModelFactory(getUserNameUseCase, saveUserNameUseCase)
    }


}