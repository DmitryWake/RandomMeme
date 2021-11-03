package com.ewake.randommeme.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ewake.randommeme.BuildConfig
import com.ewake.randommeme.data.database.dao.MemeDao
import com.ewake.randommeme.data.database.entity.MemeEntity

/**
 * @author Nikolaevsky Dmitry (@d.nikolaevskiy)
 */
@Database(version = BuildConfig.DATABASE_VERSION, entities = [MemeEntity::class])
abstract class AppDatabase : RoomDatabase() {
    abstract fun memeDao(): MemeDao
}