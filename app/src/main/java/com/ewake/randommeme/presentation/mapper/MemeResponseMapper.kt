package com.ewake.randommeme.presentation.mapper

import com.ewake.randommeme.data.api.model.MemeResponse
import com.ewake.randommeme.presentation.model.MemeItemModel
import javax.inject.Inject

/**
 * @author Nikolaevsky Dmitry (@d.nikolaevskiy)
 */
class MemeResponseMapper @Inject constructor() {
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
}