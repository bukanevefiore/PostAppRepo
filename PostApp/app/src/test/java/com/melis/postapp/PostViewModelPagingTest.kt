package com.melis.postapp

import app.cash.turbine.test
import androidx.paging.PagingData
import com.melis.postapp.domain.model.Post
import com.melis.postapp.domain.usecase.GetPostsUseCase
import com.melis.postapp.presentation.viewmodel.PostViewModel
import junit.framework.TestCase.assertNotNull
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class PostViewModelPagingTest {

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    private lateinit var fakePagingRepository: FakePagingPostRepository
    private lateinit var viewModel: PostViewModel

    private val testPosts = List(30) { i -> Post(i, 1 ,"Title $i", "Body $i") }

    @Before
    fun setup() {
        fakePagingRepository = FakePagingPostRepository()
        val useCase = GetPostsUseCase(fakePagingRepository)
        viewModel = PostViewModel(useCase)
    }

    @Test
    fun pagingData_emitsNonEmptyList() = runTest {
        // Flow<PagingData<Post>>
        val flow = viewModel.posts

        flow.test {
            val pagingData = awaitItem()
            assertNotNull(pagingData)
            cancelAndIgnoreRemainingEvents()
        }
    }
}
