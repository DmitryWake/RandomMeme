package com.ewake.randommeme.domain.usecase

import com.ewake.randommeme.domain.repository.memerepository.MemeRepository
import javax.inject.Inject

/**
 * @author Nikolaevsky Dmitry (@d.nikolaevskiy)
 */
class MemesUseCase @Inject constructor(private val repository: MemeRepository) {
    suspend operator fun invoke(query: String, count: Int) = repository.getRandomMemes(query, count)
}