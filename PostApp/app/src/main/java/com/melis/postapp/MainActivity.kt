package com.melis.postapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.melis.postapp.presentation.navigation.AppNavGraph
import com.melis.postapp.ui.theme.PostAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PostAppTheme {
                val navController = rememberNavController()
                AppNavGraph(navController)
            }
        }
    }
}

