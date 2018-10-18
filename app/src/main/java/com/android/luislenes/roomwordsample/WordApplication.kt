package com.android.luislenes.roomwordsample

import android.app.Application
import com.android.luislenes.roomwordsample.di.components.AppComponent
import com.android.luislenes.roomwordsample.di.components.DaggerAppComponent
import com.android.luislenes.roomwordsample.di.components.DaggerWordsComponent
import com.android.luislenes.roomwordsample.di.components.WordsComponent
import com.android.luislenes.roomwordsample.di.modules.AppModule
import com.android.luislenes.roomwordsample.di.modules.WordsModule

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
                .appComponent(getAppComponent())
                .wordsModule(WordsModule())
                .build()
    }

    fun getAppComponent() : AppComponent {
        return DaggerAppComponent.builder().appModule(AppModule(this)).build()
    }
}