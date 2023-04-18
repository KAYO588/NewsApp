package com.example.newsapp.data.api.dp

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

abstract class ArticleDataBase: RoomDatabase() {
    abstract fun getArticleDao(): ArticleDao

    companion object {
        @Volatile
        private var instance: ArticleDataBase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance?: synchronized(LOCK) {
            instance ?: createDtaBase(context).also { instance = it }

        }
        private fun createDtaBase(context: Context): ArticleDataBase {
            return Room.databaseBuilder(
                context.applicationContext,
                ArticleDataBase::class.java,
                "article_database"
            ).build()
        }
    }
}