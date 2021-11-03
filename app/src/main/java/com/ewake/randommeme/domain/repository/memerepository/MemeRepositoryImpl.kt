package com.ewake.randommeme.domain.repository.memerepository

import com.ewake.randommeme.data.api.Api
import com.ewake.randommeme.data.api.model.MemeResponse
import com.ewake.randommeme.data.api.model.MemesResponse
import com.ewake.randommeme.data.database.AppDatabase
import com.ewake.randommeme.domain.mapper.MemeMapper
import com.ewake.randommeme.presentation.model.MemeItemModel
import javax.inject.Inject

/**
 * Репозиторий по получению мемов
 * @author Nikolaevsky Dmitry (@d.nikolaevskiy)
 */
class MemeRepositoryImpl @Inject constructor(
    private val api: Api,
    appDatabase: AppDatabase,
    private val mapper: MemeMapper,
) : MemeRepository {

    private val memeDao = appDatabase.memeDao()

    /**
     * Получение рандомного мема по категории
     * @param query (Поисковый запрос категории, по дефолту "itmeme")
     */
    override suspend fun getRandomMeme(query: String): Result<MemeItemModel> {
        return kotlin.runCatching {
            mapper.responseToModel(api.getRandomMeme(query))
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
    ): Result<List<MemeItemModel>> {
        kotlin.runCatching {
            api.getRandomMemes(query, count)
        }.onSuccess {
            memeDao.deleteAll()
            memeDao.insert(mapper.responseListToEntityList(it.memes))
        }

        return kotlin.runCatching {
            mapper.entityListToModelList(memeDao.getAll())
        }
    }
}