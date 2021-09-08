package com.ewake.randommeme.domain.usecase

import com.ewake.randommeme.domain.repository.memerepository.MemeRepository
import javax.inject.Inject

/**
 * @author Nikolaevsky Dmitry (@d.nikolaevskiy)
 */
class MemeUseCase @Inject constructor(private val memeRepository: MemeRepository) {
    suspend operator fun invoke(query: String) = memeRepository.getRandomMeme(query)
}