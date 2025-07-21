package com.melis.postapp.presentation.state

sealed class PostUiState {
    object Loading : PostUiState()
    data class Success(val posts: List<com.melis.postapp.domain.model.Post>) : PostUiState()
    data class Error(val message: String) : PostUiState()
}