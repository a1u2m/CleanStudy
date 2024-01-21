package com.example.kiparomvvm.app

import android.app.Application
import com.example.kiparomvvm.di.AppComponent
import com.example.kiparomvvm.di.AppModule
import com.example.kiparomvvm.di.DaggerAppComponent

class App : Application() {

    lateinit var appComponent: AppComponent
    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder().appModule(AppModule(this)).build()
    }
}