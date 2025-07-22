package com.melis.postapp

import androidx.paging.AsyncPagingDataDiffer
import com.melis.postapp.domain.model.Post
import com.melis.postapp.domain.usecase.GetPostsUseCase
import com.melis.postapp.presentation.viewmodel.PostViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

/*
@OptIn(ExperimentalCoroutinesApi::class)
@RunWith(RobolectricTestRunner::class)
@Config(sdk = [33])
class PostViewModelTest {

    @get:Rule
    val dispatcherRule = MainDispatcherRule()

    private lateinit var viewModel: PostViewModel
    private lateinit var fakeRepository: FakePostRepository

    @Before
    fun setup() {
        fakeRepository = FakePostRepository()
        val useCase = GetPostsUseCase(fakeRepository)
        viewModel = PostViewModel(useCase)
    }

    @Test
    fun `ViewModel emits paging data`() = runTest {
        // Arrange
        val samplePosts = listOf(Post(1, 1, "Test Title", "Test Body"))
        fakeRepository.addPosts(samplePosts)

        // Act
        val pagingData = viewModel.posts.first()

        val differ = AsyncPagingDataDiffer(
            diffCallback = PostDiffCallback(),
            updateCallback = NoopListUpdateCallback,
            mainDispatcher = dispatcherRule.dispatcher,
            workerDispatcher = dispatcherRule.dispatcher
        )

        differ.submitData(pagingData)
        advanceUntilIdle()

        // Assert
        val snapshot = differ.snapshot()
        assertEquals(1, snapshot.size)
        assertEquals("Test Title", snapshot[0]?.title)
    }
} */