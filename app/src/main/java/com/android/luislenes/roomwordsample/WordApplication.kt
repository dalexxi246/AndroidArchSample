package com.android.luislenes.roomwordsample

import android.app.Application
import com.android.luislenes.roomwordsample.di.AppModule
import com.android.luislenes.roomwordsample.di.DaggerWordsComponent
import com.android.luislenes.roomwordsample.di.WordsComponent
import com.android.luislenes.roomwordsample.di.WordsModule

class WordApplication : Application() {

    companion object {
        lateinit var app: WordApplication
    }

    override fun onCreate() {
        super.onCreate()
        WordApplication.app = this
    }

    fun getWordsComponent(): WordsComponent {
        return DaggerWordsComponent.builder()
                .appModule(AppModule(this))
                .wordsModule(WordsModule())
                .build()
    }
}