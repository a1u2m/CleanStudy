package com.example.kiparomvvm.domain.usecase

import com.example.kiparomvvm.domain.models.UserName
import com.example.kiparomvvm.domain.repository.UserRepository
import javax.inject.Inject

class GetUserNameUseCase (private val userRepository: UserRepository) {

    fun execute(): UserName {
        return userRepository.getName()
    }
}