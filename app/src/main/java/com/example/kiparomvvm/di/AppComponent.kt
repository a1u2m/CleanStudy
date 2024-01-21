package com.example.kiparomvvm.di

import com.example.kiparomvvm.presentation.MainActivity
import dagger.Component

@Component(modules = [AppModule::class, DataModule::class, DomainModule::class])
interface AppComponent {

    fun inject(mainActivity: MainActivity)

}