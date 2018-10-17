package com.android.luislenes.roomwordsample.di

import android.arch.persistence.room.Room
import android.content.Context
import com.android.luislenes.roomwordsample.persistence.AppDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val context: Context) {

    @Provides
    @Singleton
    fun providesDatabase() : AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, "word_database").build()
    }

}