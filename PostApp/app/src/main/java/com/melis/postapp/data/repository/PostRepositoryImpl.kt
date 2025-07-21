package com.melis.postapp.data.repository


import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.melis.postapp.data.paging.PostPagingSource
import com.melis.postapp.data.remote.PostApi
import com.melis.postapp.domain.model.Post
import com.melis.postapp.domain.repository.PostRepository
import kotlinx.coroutines.flow.Flow

class PostRepositoryImpl(
    private val api: PostApi
) : PostRepository {
    override fun getPosts(): Flow<PagingData<Post>> {
        return Pager(
            config = PagingConfig(pageSize = 10, enablePlaceholders = false),
            pagingSourceFactory = { PostPagingSource(api) }
        ).flow
    }
}