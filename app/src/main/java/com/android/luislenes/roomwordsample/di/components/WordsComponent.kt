package com.android.luislenes.roomwordsample.di.components

import com.android.luislenes.roomwordsample.di.modules.WordsModule
import com.android.luislenes.roomwordsample.di.scopes.PerModule
import com.android.luislenes.roomwordsample.domain.WordsUseCase
import dagger.Component

@PerModule
@Component(modules = [WordsModule::class], dependencies = [AppComponent::class])
interface WordsComponent {

    fun wordsUseCase(): WordsUseCase

}