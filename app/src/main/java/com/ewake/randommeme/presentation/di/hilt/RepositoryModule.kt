package com.ewake.randommeme.presentation.di.hilt

import com.ewake.randommeme.data.api.Api
import com.ewake.randommeme.data.database.AppDatabase
import com.ewake.randommeme.domain.mapper.MemeMapper
import com.ewake.randommeme.domain.repository.memerepository.MemeRepository
import com.ewake.randommeme.domain.repository.memerepository.MemeRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * @author Nikolaevsky Dmitry (@d.nikolaevskiy)
 */
@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    fun providerMemeRepository(
        api: Api,
        appDatabase: AppDatabase,
        mapper: MemeMapper
    ): MemeRepository =
        MemeRepositoryImpl(api, appDatabase, mapper)
}