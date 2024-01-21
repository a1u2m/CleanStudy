package com.example.kiparomvvm.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.kiparomvvm.domain.usecase.GetUserNameUseCase
import com.example.kiparomvvm.domain.usecase.SaveUserNameUseCase
import javax.inject.Inject

class MainViewModelFactory (
    private val getUserNameUseCase: GetUserNameUseCase,
    private val saveUserNameUseCase: SaveUserNameUseCase
) : ViewModelProvider.Factory {


    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(getUserNameUseCase, saveUserNameUseCase) as T
    }
}