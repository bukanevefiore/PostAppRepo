package com.melis.postapp.data.mapper

import com.melis.postapp.data.remote.PostDto
import com.melis.postapp.domain.model.Post

fun PostDto.toDomain(): Post {
    return Post(
        id = id,
        userId = userId,
        title = title,
        body = body
    )
}