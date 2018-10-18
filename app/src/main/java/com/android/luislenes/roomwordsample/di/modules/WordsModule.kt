package com.android.luislenes.roomwordsample.di.modules

import com.android.luislenes.roomwordsample.di.scopes.PerModule
import com.android.luislenes.roomwordsample.domain.WordUseCaseImpl
import com.android.luislenes.roomwordsample.domain.WordsUseCase
import com.android.luislenes.roomwordsample.persistence.AppDatabase
import com.android.luislenes.roomwordsample.persistence.RoomWordRepository
import com.android.luislenes.roomwordsample.persistence.WordRepository
import dagger.Module
import dagger.Provides

@Module
class WordsModule {

    @Provides
    @PerModule
    fun providesWordUseCase(wordRepository: WordRepository): WordsUseCase {
        return WordUseCaseImpl(wordRepository)
    }

    @Provides
    @PerModule
    fun providesWordRepository(appDatabase: AppDatabase) : WordRepository {
        return RoomWordRepository(appDatabase.wordDao())
    }

}