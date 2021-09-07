package com.ewake.randommeme.data.api.model

import com.google.gson.annotations.SerializedName

/**
 * @author Nikolaevsky Dmitry (@d.nikolaevskiy)
 */
data class MemeResponse(
    @SerializedName("postLink")
    var postLink: String = "",
    @SerializedName("subreddit")
    var subreddit: String = "",
    @SerializedName("title")
    var title: String = "",
    @SerializedName("url")
    var url: String = "",
    @SerializedName("nsfw")
    var nsfw: Boolean = false,
    @SerializedName("spoiler")
    var spoiler: Boolean = false,
    @SerializedName("author")
    var author: String = "",
    @SerializedName("ups")
    var ups: Int = 0,
    @SerializedName("preview")
    var preview: List<String> = listOf()
)

