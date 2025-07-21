package com.melis.postapp.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.melis.postapp.data.mapper.toDomain
import com.melis.postapp.data.remote.PostApi
import com.melis.postapp.domain.model.Post

class PostPagingSource(
    private val api: PostApi
) : PagingSource<Int, Post>() {

    override fun getRefreshKey(state: PagingState<Int, Post>): Int? {
        return state.anchorPosition?.let { position ->
            val anchorPage = state.closestPageToPosition(position)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Post> {
        return try {
            val page = params.key ?: 1
            val response = api.getPosts(page, params.loadSize)
            val posts = response.map { it.toDomain() }

            LoadResult.Page(
                data = posts,
                prevKey = if (page == 1) null else page - 1,
                nextKey = if (posts.isEmpty()) null else page + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}