package com.melis.postapp

import androidx.paging.PagingData
import com.melis.postapp.domain.model.Post
import com.melis.postapp.domain.repository.PostRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FakePostRepository : PostRepository {

    private val posts = mutableListOf<Post>()

    fun addPosts(postList: List<Post>) {
        posts.addAll(postList)
    }

    override fun getPosts(): Flow<PagingData<Post>> {
        return flow {
            emit(PagingData.from(posts))
        }
    }
}