package com.example.kiparomvvm.domain.repository

import com.example.kiparomvvm.domain.models.SaveUserNameParam
import com.example.kiparomvvm.domain.models.UserName

interface UserRepository {

    fun saveName(saveParam: SaveUserNameParam): Boolean
    fun getName(): UserName
}