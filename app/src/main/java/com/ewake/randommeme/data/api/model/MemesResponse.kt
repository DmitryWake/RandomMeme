package com.ewake.randommeme.data.api.model

import com.google.gson.annotations.SerializedName

/**
 * @author Nikolaevsky Dmitry (@d.nikolaevskiy)
 */
data class MemesResponse(
    @SerializedName("count")
    var count: Int = 0,
    @SerializedName("memes")
    var memes: List<MemeResponse> = listOf()
)