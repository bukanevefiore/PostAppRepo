package com.melis.postapp.presentation.navigation

sealed class Screen(val route: String) {
    object PostList : Screen("post_list")
}