package com.melis.postapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.paging.compose.collectAsLazyPagingItems
import com.melis.postapp.presentation.ui.PostScreen
import com.melis.postapp.presentation.viewmodel.PostViewModel

@Composable
fun AppNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "posts") {
        composable("posts") {
            val viewModel: PostViewModel = hiltViewModel()
            val posts = viewModel.posts.collectAsLazyPagingItems()
            PostScreen(posts = posts)
        }
    }
}