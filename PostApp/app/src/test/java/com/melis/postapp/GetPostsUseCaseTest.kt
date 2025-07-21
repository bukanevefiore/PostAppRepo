package com.melis.postapp

import com.melis.postapp.domain.model.Post
import com.melis.postapp.domain.usecase.GetPostsUseCase
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class GetPostsUseCaseTest {

    private lateinit var fakeRepository: FakePostRepository
    private lateinit var getPostsUseCase: GetPostsUseCase

    @Before
    fun setup() {
        fakeRepository = FakePostRepository()
        getPostsUseCase = GetPostsUseCase(fakeRepository)
    }

    @Test
    fun `GetPostsUseCase returns posts successfully`() = runBlocking {
        val samplePosts = listOf(
            Post(1, 1, "Test Title 1", "Test Body 1"),
            Post(2, 1, "Test Title 2", "Test Body 2")
        )
        fakeRepository.addPosts(samplePosts)

        val result = getPostsUseCase()


    }
}