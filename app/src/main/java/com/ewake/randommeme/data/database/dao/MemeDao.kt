package com.ewake.randommeme.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ewake.randommeme.data.database.entity.MemeEntity

/**
 * @author Nikolaevsky Dmitry (@d.nikolaevskiy)
 */
@Dao
interface MemeDao {

    @Query("SELECT * FROM memeEntity")
    suspend fun getAll(): List<MemeEntity>

    @Query("SELECT * FROM memeEntity WHERE id LIKE :id LIMIT 1")
    suspend fun get(id: Long): MemeEntity

    @Query("DELETE FROM memeEntity")
    suspend fun deleteAll()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(list: List<MemeEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(entity: MemeEntity)
}