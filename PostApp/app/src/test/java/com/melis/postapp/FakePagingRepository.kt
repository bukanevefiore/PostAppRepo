package com.melis.postapp

import androidx.paging.PagingData
import com.melis.postapp.domain.model.Post
import com.melis.postapp.domain.repository.PostRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class FakePagingPostRepository : PostRepository {
    override fun getPosts(): Flow<PagingData<Post>> {
        val fakePosts = List(10) { index ->
            Post(id = index, title = "Title $index", body = "Body $index")
        }
        return flowOf(PagingData.from(fakePosts))
    }
}