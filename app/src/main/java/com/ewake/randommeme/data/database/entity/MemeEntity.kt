package com.ewake.randommeme.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @author Nikolaevsky Dmitry (@d.nikolaevskiy)
 */
@Entity(tableName = "memeEntity")
data class MemeEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Long? = null,
    var postLink: String = "",
    var subreddit: String = "",
    var title: String = "",
    var url: String = "",
    var author: String = ""
)
