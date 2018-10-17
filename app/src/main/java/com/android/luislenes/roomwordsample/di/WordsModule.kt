package com.android.luislenes.roomwordsample.di

import com.android.luislenes.roomwordsample.domain.WordUseCaseImpl
import com.android.luislenes.roomwordsample.domain.WordsUseCase
import com.android.luislenes.roomwordsample.persistence.AppDatabase
import com.android.luislenes.roomwordsample.persistence.RoomWordRepository
import com.android.luislenes.roomwordsample.persistence.WordRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class WordsModule {

    @Provides
    fun providesWordUseCase(wordRepository: WordRepository): WordsUseCase {
        return WordUseCaseImpl(wordRepository)
    }

    @Provides
    @Singleton
    fun providesWordRepository(appDatabase: AppDatabase) : WordRepository {
        return RoomWordRepository(appDatabase)
    }

}