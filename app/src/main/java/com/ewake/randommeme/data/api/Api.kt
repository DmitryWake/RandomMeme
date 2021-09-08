package com.ewake.randommeme.data.api

import com.ewake.randommeme.data.api.model.MemeResponse
import com.ewake.randommeme.data.api.model.MemesResponse
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * @author Nikolaevsky Dmitry (@d.nikolaevskiy)
 */
interface Api {

    @GET("gimme/{query}")
    suspend fun getRandomMeme(@Path("query") query: String): MemeResponse

    @GET("gimme/{query}/{count}")
    suspend fun getRandomMemes(
        @Path("query") query: String,
        @Path("count") count: Int = 50
    ): MemesResponse
}