package com.ewake.randommeme.domain.repository.memerepository

import com.ewake.randommeme.data.api.model.MemeResponse
import com.ewake.randommeme.data.api.model.MemesResponse
import com.ewake.randommeme.presentation.model.MemeItemModel

/**
 * Репозиторий по получению мемов
 * @author Nikolaevsky Dmitry (@d.nikolaevskiy)
 */
interface MemeRepository {

    /**
     * Получение рандомного мема по категории
     * @param query (Поисковый запрос категории, по дефолту "itmeme")
     */
    suspend fun getRandomMeme(query: String = BASE_CATEGORY): Result<MemeItemModel>

    /**
     * Получение рандомных мемов по категории
     * @param query (Поисковый запрос категории, по дефолту "itmeme")
     * @param count (Количество выходящих элементов)
     */
    suspend fun getRandomMemes(
        query: String = BASE_CATEGORY,
        count: Int = MAX_ITEMS_COUNT
    ): Result<List<MemeItemModel>>

    companion object {
        const val BASE_CATEGORY = "itmeme"
        const val MAX_ITEMS_COUNT = 50
    }
}