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

@OptIn(ExperimentalCoroutinesApi::class)
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
    fun `ViewModel loads posts successfully`() = runTest {
        val samplePosts = listOf(
            Post(1, 1, "Test Title", "Test Body")
        )
        fakeRepository.addPosts(samplePosts)

        val differ = AsyncPagingDataDiffer(
            diffCallback = PostDiffCallback(),
            updateCallback = NoopListUpdateCallback,
            mainDispatcher = dispatcherRule.dispatcher,
            workerDispatcher = dispatcherRule.dispatcher
        )

        val pagingData = viewModel.posts.first()

        differ.submitData(pagingData)
        advanceUntilIdle()

        assertEquals(1, differ.snapshot().size)
        assertEquals("Test Title", differ.snapshot()[0]?.title)
    }
}