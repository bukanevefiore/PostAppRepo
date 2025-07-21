package com.melis.postapp

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.melis.postapp.domain.model.Post

class FakePostPagingSource(private val posts: List<Post>) : PagingSource<Int, Post>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Post> {
        val page = params.key ?: 1
        val pageSize = params.loadSize
        val fromIndex = (page - 1) * pageSize
        val toIndex = kotlin.math.min(fromIndex + pageSize, posts.size)

        return if (fromIndex >= posts.size) {
            LoadResult.Page(emptyList(), prevKey = if (page == 1) null else page -1, nextKey = null)
        } else {
            LoadResult.Page(posts.subList(fromIndex, toIndex), prevKey = if (page == 1) null else page -1, nextKey = if (toIndex < posts.size) page + 1 else null)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Post>): Int? = 1
}