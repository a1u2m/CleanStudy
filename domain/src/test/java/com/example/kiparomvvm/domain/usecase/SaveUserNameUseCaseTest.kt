package com.example.kiparomvvm.domain.usecase

import com.example.kiparomvvm.domain.models.SaveUserNameParam
import com.example.kiparomvvm.domain.models.UserName
import com.example.kiparomvvm.domain.repository.UserRepository
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.mockito.kotlin.any
import org.mockito.kotlin.mock

class SaveUserNameUseCaseTest {

    private val userRepository = mock<UserRepository>()

    @AfterEach
    fun tearDown() {
        Mockito.reset(userRepository)
    }

    @Test
    fun `should not save data if name was alreadt saved`() {
        val testUserName = UserName("test first name", "test last name")
        Mockito.`when`(userRepository.getName()).thenReturn(testUserName)

        val useCase = SaveUserNameUseCase(userRepository)
        val testParams = SaveUserNameParam("test first name")
        val actual = useCase.execute(testParams)
        val expected = true
        Assertions.assertEquals(expected, actual)
        Mockito.verify(userRepository, Mockito.never()).saveName(any())
    }

    @Test
    fun `should return true if save was successful`() {
        val testUserName = UserName("test first name", "test last name")
        Mockito.`when`(userRepository.getName()).thenReturn(testUserName)

        val expected = true
        val testParams = SaveUserNameParam("new first name")
        Mockito.`when`(userRepository.saveName(testParams)).thenReturn(expected)

        val useCase = SaveUserNameUseCase(userRepository)
        val actual = useCase.execute(testParams)

        Assertions.assertEquals(expected, actual)
        Mockito.verify(userRepository, Mockito.times(1)).saveName(testParams)
    }

    @Test
    fun `should return false if save was unsuccessful`() {
        val testUserName = UserName("test first name", "test last name")
        Mockito.`when`(userRepository.getName()).thenReturn(testUserName)

        val expected = false
        val testParams = SaveUserNameParam("new first name")
        Mockito.`when`(userRepository.saveName(testParams)).thenReturn(expected)

        val useCase = SaveUserNameUseCase(userRepository)
        val actual = useCase.execute(testParams)

        Assertions.assertEquals(expected, actual)
        Mockito.verify(userRepository, Mockito.times(1)).saveName(testParams)
    }
}