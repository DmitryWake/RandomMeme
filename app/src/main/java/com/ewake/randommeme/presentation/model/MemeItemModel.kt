package com.ewake.randommeme.presentation.model

/**
 * @author Nikolaevsky Dmitry (@d.nikolaevskiy)
 */
data class MemeItemModel(
    var id: Long? = null,
    var postLink: String = "",
    var title: String = "",
    var author: String = "",
    val url: String = "",
)
