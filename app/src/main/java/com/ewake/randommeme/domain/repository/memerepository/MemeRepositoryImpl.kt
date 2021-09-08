package com.ewake.randommeme.domain.repository.memerepository

import com.ewake.randommeme.data.api.Api
import com.ewake.randommeme.data.api.model.MemeResponse
import com.ewake.randommeme.data.api.model.MemesResponse
import javax.inject.Inject

/**
 * Репозиторий по получению мемов
 * @author Nikolaevsky Dmitry (@d.nikolaevskiy)
 */
class MemeRepositoryImpl @Inject constructor(
    private val api: Api
) : MemeRepository {

    /**
     * Получение рандомного мема по категории
     * @param query (Поисковый запрос категории, по дефолту "itmeme")
     */
    override suspend fun getRandomMeme(query: String): Result<MemeResponse> {
        return kotlin.runCatching {
            api.getRandomMeme(query)
        }
    }

    /**
     * Получение рандомных мемов по категории
     * @param query (Поисковый запрос категории, по дефолту "itmeme")
     * @param count (Количество выходящих элементов)
     */
    override suspend fun getRandomMemes(
        query: String,
        count: Int
    ): Result<MemesResponse> {
        return kotlin.runCatching {
            api.getRandomMemes(query, count)
        }
    }
}