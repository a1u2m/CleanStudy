package com.example.kiparomvvm.presentation

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.kiparomvvm.data.repository.UserRepositoryImpl
import com.example.kiparomvvm.data.storage.sharefprefs.SharedPrefUserStorage
import com.example.kiparomvvm.domain.usecase.GetUserNameUseCase
import com.example.kiparomvvm.domain.usecase.SaveUserNameUseCase

class MainViewModelFactory(context: Context) : ViewModelProvider.Factory {

    private val userRepositoryImpl by lazy(LazyThreadSafetyMode.NONE) {
        UserRepositoryImpl(
            SharedPrefUserStorage(context)
        )
    }
    private val getUserNameUseCase by lazy(LazyThreadSafetyMode.NONE) {
        GetUserNameUseCase(
            userRepositoryImpl
        )
    }
    private val saveUserNameUseCase by lazy(LazyThreadSafetyMode.NONE) {
        SaveUserNameUseCase(
            userRepositoryImpl
        )
    }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(getUserNameUseCase, saveUserNameUseCase) as T
    }
}