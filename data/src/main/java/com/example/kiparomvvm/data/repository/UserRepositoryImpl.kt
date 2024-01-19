package com.example.kiparomvvm.data.repository

import com.example.kiparomvvm.data.storage.models.User
import com.example.kiparomvvm.data.storage.UserStorage
import com.example.kiparomvvm.domain.models.SaveUserNameParam
import com.example.kiparomvvm.domain.models.UserName
import com.example.kiparomvvm.domain.repository.UserRepository


class UserRepositoryImpl(private val userStorage: UserStorage) :
    UserRepository {

    override fun saveName(saveParam: SaveUserNameParam): Boolean {
        val user = mapToStorage(saveParam)
        return userStorage.save(user)
    }

    override fun getName(): UserName {
        val user = userStorage.get()
        return mapToDomain(user)
    }

    private fun mapToDomain(user: User): UserName {
        return UserName(user.firstName, user.lastName)
    }

    private fun mapToStorage(user: SaveUserNameParam): User {
        return User(user.name, "")
    }
}