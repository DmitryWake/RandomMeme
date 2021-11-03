package com.ewake.randommeme.domain.mapper

import com.ewake.randommeme.data.api.model.MemeResponse
import com.ewake.randommeme.data.database.entity.MemeEntity
import com.ewake.randommeme.presentation.model.MemeItemModel
import javax.inject.Inject

/**
 * @author Nikolaevsky Dmitry (@d.nikolaevskiy)
 */
class MemeMapper @Inject constructor() {
    fun entityToModel(entity: MemeEntity): MemeItemModel {
        return MemeItemModel(
            postLink = entity.postLink,
            url = entity.url,
            author = entity.author,
            title = entity.title,
            id = entity.id
        )
    }

    fun entityListToModelList(list: List<MemeEntity>): List<MemeItemModel> {
        return list.map { entityToModel(it) }
    }

    fun responseToModel(response: MemeResponse): MemeItemModel {
        return MemeItemModel(
            postLink = response.postLink,
            title = response.title,
            author = response.author,
            url = response.url
        )
    }

    fun responseListToModelList(list: List<MemeResponse>): List<MemeItemModel> {
        return list.map { responseToModel(it) }
    }

    fun responseToEntity(response: MemeResponse): MemeEntity {
        return MemeEntity(
            postLink = response.postLink,
            title = response.title,
            author = response.author,
            url = response.url,
            subreddit = response.subreddit
        )
    }

    fun responseListToEntityList(list: List<MemeResponse>): List<MemeEntity> {
        return list.map { responseToEntity(it) }
    }
}