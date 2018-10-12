package com.android.luislenes.roomwordsample

import android.app.Application
import com.android.luislenes.roomwordsample.di.AppComponent
import com.android.luislenes.roomwordsample.di.AppModule
import com.android.luislenes.roomwordsample.di.DaggerAppComponent

class WordApplication : Application() {

    companion object {
        private lateinit var _appComponent : AppComponent
        val appComponent : AppComponent get() = _appComponent
    }

    override fun onCreate() {
        super.onCreate()
        initializeDagger()
    }

    private fun initializeDagger() {
        _appComponent = DaggerAppComponent.builder().appModule(AppModule(this)).build()
    }
}