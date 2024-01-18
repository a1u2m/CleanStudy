package com.example.kiparomvvm.data.storage

import com.example.kiparomvvm.data.storage.models.User

interface UserStorage {

    fun save(user: User): Boolean
    fun get(): User
}