package com.example.kiparomvvm.presentation

import androidx.arch.core.executor.ArchTaskExecutor
import androidx.arch.core.executor.TaskExecutor
import com.example.kiparomvvm.data.storage.models.User
import com.example.kiparomvvm.domain.models.SaveUserNameParam
import com.example.kiparomvvm.domain.models.UserName
import com.example.kiparomvvm.domain.usecase.GetUserNameUseCase
import com.example.kiparomvvm.domain.usecase.SaveUserNameUseCase
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.mockito.kotlin.any
import org.mockito.kotlin.mock

class MainViewModelTest {

    private val getUserNameUseCase = mock<GetUserNameUseCase>()
    private val saveUserNameUseCase = mock<SaveUserNameUseCase>()
    private lateinit var viewModel: MainViewModel

    @AfterEach
    fun afterEach() {
        Mockito.reset(getUserNameUseCase)
        Mockito.reset(saveUserNameUseCase)
        ArchTaskExecutor.getInstance().setDelegate(null)
    }

    @BeforeEach
    fun beforeEach() {
        ArchTaskExecutor.getInstance().setDelegate(object : TaskExecutor() {
            override fun executeOnDiskIO(runnable: Runnable) {
                runnable.run()
            }

            override fun isMainThread(): Boolean {
                return true
            }

            override fun postToMainThread(runnable: Runnable) {
                runnable.run()
            }
        })
        viewModel = MainViewModel(getUserNameUseCase, saveUserNameUseCase)
    }


    @Test
    fun `should save username and return true`() {
        val saveResult = true
        val testSaveText = "Test user name"
        val testParams = SaveUserNameParam(testSaveText)
        Mockito.`when`(saveUserNameUseCase.execute(testParams)).thenReturn(saveResult)
        viewModel.save(testSaveText)
        val expected = "Save result = true"
        val actual = viewModel.resultLive.value
        Mockito.verify(saveUserNameUseCase, Mockito.times(1)).execute(testParams)
        Assertions.assertEquals(expected, actual)
    }

    @Test
    fun `should save username and return false`() {
        val saveResult = false
        val testSaveText = "Test user name"
        val testParams = SaveUserNameParam(testSaveText)
        Mockito.`when`(saveUserNameUseCase.execute(testParams)).thenReturn(saveResult)
        viewModel.save(testSaveText)
        val expected = "Save result = false"
        val actual = viewModel.resultLive.value
        Mockito.verify(saveUserNameUseCase, Mockito.times(1)).execute(testParams)
        Assertions.assertEquals(expected, actual)
    }

    @Test
    fun `should load username`() {
        val testUserName = UserName("Test first name", "Test last name")
        Mockito.`when`(getUserNameUseCase.execute()).thenReturn(testUserName)
        viewModel.load()
        val expected = "${testUserName.firstName} ${testUserName.lastName}"
        val actual = viewModel.resultLive.value
        Mockito.verify(getUserNameUseCase, Mockito.times(1)).execute()
        Assertions.assertEquals(expected, actual)
    }
}