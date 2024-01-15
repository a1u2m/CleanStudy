package com.example.kiparomvvm.domain.usecase

import com.example.kiparomvvm.domain.models.SaveUserNameParam

class SaveUserNameUseCase {

    fun execute(param: SaveUserNameParam): Boolean {
        return param.name.isNotEmpty()
    }
}