package com.melis.postapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.melis.postapp.domain.model.Post
import com.melis.postapp.domain.usecase.GetPostsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class PostViewModel @Inject constructor(
    getPostsUseCase: GetPostsUseCase
) : ViewModel() {

    val posts: Flow<PagingData<Post>> = getPostsUseCase().cachedIn(viewModelScope)
}