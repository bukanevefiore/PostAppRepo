package com.melis.postapp.domain.usecase

import androidx.paging.PagingData
import com.melis.postapp.domain.model.Post
import com.melis.postapp.domain.repository.PostRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPostsUseCase @Inject constructor(
    private val repository: PostRepository
) {
    operator fun invoke(): Flow<PagingData<Post>> = repository.getPosts()
}