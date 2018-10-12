package com.android.luislenes.roomwordsample.di

import com.android.luislenes.roomwordsample.ui.main.MainActivity
import com.android.luislenes.roomwordsample.persistence.WordRepository
import com.android.luislenes.roomwordsample.ui.main.MainViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    fun inject(activity: MainActivity)
    fun inject(repository: WordRepository)
    fun inject(mainViewModel: MainViewModel)
}