package com.ewake.randommeme.data.api

import com.ewake.randommeme.data.api.model.MemeResponse
import com.ewake.randommeme.data.api.model.MemesResponse
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * @author Nikolaevsky Dmitry (@d.nikolaevskiy)
 */
interface Api {

    @GET("gimme/it")
    suspend fun getRandomMeme(): MemeResponse

    @GET("gimme/it/{count}")
    suspend fun getRandomMemes(@Path("count") count: Int): MemesResponse
}