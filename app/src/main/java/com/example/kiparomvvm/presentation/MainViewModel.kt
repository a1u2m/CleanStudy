package com.example.kiparomvvm.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kiparomvvm.domain.models.SaveUserNameParam
import com.example.kiparomvvm.domain.usecase.GetUserNameUseCase
import com.example.kiparomvvm.domain.usecase.SaveUserNameUseCase

class MainViewModel(
    private val getUserNameUseCase: GetUserNameUseCase,
    private val saveUserNameUseCase: SaveUserNameUseCase
) : ViewModel() {

    private val _resultLive = MutableLiveData<String>()
    val resultLive
        get() = _resultLive as LiveData<String>

    fun save(text: String) {
        val params = SaveUserNameParam(name = text)
        val result = saveUserNameUseCase.execute(param = params)
        _resultLive.value = "Save result = $result"
    }

    fun load() {
        val userName = getUserNameUseCase.execute()
        _resultLive.value = "${userName.firstName} ${userName.lastName}"
    }
}