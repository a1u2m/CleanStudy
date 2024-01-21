package com.example.kiparomvvm.domain.usecase

import com.example.kiparomvvm.domain.models.SaveUserNameParam
import com.example.kiparomvvm.domain.models.UserName
import com.example.kiparomvvm.domain.repository.UserRepository
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.mockito.Mockito.mock
import org.mockito.kotlin.mock

class TestRepository : UserRepository {
    override fun saveName(saveParam: SaveUserNameParam): Boolean {
        return true
    }

    override fun getName(): UserName {
        return UserName("test first name", "test last name")
    }
}

class GetUserNameUseCaseTest {
    @Test
    fun `should return the same data as in repository`() {
        val testRepository = TestRepository()
        val useCase = GetUserNameUseCase(testRepository)
        val actual = useCase.execute()
        val expected = UserName("test first name", "test last name")
        Assertions.assertEquals(expected, actual)
    }
}