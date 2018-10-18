package com.android.luislenes.roomwordsample.di.components

import android.content.Context
import com.android.luislenes.roomwordsample.di.modules.AppModule
import com.android.luislenes.roomwordsample.persistence.AppDatabase
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {

    fun applicationContext() : Context

    // Required by WordsComponent
    fun appDatabase() : AppDatabase

}