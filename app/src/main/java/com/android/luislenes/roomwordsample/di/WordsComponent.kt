package com.android.luislenes.roomwordsample.di

import com.android.luislenes.roomwordsample.domain.WordsUseCase
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [WordsModule::class, AppModule::class])
interface WordsComponent {

    fun wordsUseCase(): WordsUseCase

}