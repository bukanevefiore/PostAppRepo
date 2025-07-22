package com.melis.postapp.presentation.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.compose.LazyPagingItems
import com.melis.postapp.domain.model.Post

@Composable
fun PostScreen(posts: LazyPagingItems<Post>) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp)
    ) {
        items(count = posts.itemCount) { index ->
            posts[index]?.let { post ->
                PostItem(post)
            }
        }
    }
}