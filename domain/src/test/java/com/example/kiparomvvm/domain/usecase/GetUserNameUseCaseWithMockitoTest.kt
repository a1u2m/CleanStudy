package com.example.kiparomvvm.domain.usecase

import com.example.kiparomvvm.domain.models.UserName
import com.example.kiparomvvm.domain.repository.UserRepository
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.mockito.kotlin.mock


class GetUserNameUseCaseWithMockitoTest {

    private val userRepository = mock<UserRepository>()

    @Test
    fun `should return the same data as in repository`() {

        val testUserName = UserName("test first name", "test last name")
        Mockito.`when`(userRepository.getName()).thenReturn(testUserName)
        val useCase = GetUserNameUseCase(userRepository)
        val actual = useCase.execute()
        val expected = UserName("test first name", "test last name")
        Assertions.assertEquals(expected, actual)
    }
}