package com.example.kiparomvvm.domain.usecase

import com.example.kiparomvvm.domain.models.UserName

class GetUserNameUseCase {

    fun execute(): UserName {
        return UserName(firstName = "Kiparo", lastName = "Hello")
    }

}