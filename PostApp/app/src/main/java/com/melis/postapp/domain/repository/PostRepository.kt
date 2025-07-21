package com.melis.postapp.domain.repository


import androidx.paging.PagingData
import com.melis.postapp.domain.model.Post
import kotlinx.coroutines.flow.Flow

interface PostRepository {
    fun getPosts(): Flow<PagingData<Post>>
}