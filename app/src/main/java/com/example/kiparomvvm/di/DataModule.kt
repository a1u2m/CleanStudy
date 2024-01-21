package com.example.kiparomvvm.di

import android.content.Context
import com.example.kiparomvvm.data.repository.UserRepositoryImpl
import com.example.kiparomvvm.data.storage.UserStorage
import com.example.kiparomvvm.data.storage.sharefprefs.SharedPrefUserStorage
import com.example.kiparomvvm.domain.repository.UserRepository
import dagger.Module
import dagger.Provides

@Module
class DataModule {

    @Provides
    fun provideUserStorage(context: Context): UserStorage {
        return SharedPrefUserStorage(context)
    }

    @Provides
    fun provideUserRepository(userStorage: UserStorage): UserRepository {
        return UserRepositoryImpl(userStorage)
    }
}