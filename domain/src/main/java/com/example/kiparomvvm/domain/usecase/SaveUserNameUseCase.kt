package com.example.kiparomvvm.domain.usecase

import com.example.kiparomvvm.domain.models.SaveUserNameParam
import com.example.kiparomvvm.domain.repository.UserRepository
import javax.inject.Inject

class SaveUserNameUseCase (private val userRepository: UserRepository) {

    fun execute(param: SaveUserNameParam): Boolean {
        val oldUserName = userRepository.getName()
        if (oldUserName.firstName == param.name) return true
        return userRepository.saveName(param)
    }
}