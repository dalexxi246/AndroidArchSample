package com.android.luislenes.roomwordsample.ui.main

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.android.luislenes.roomwordsample.WordApplication
import com.android.luislenes.roomwordsample.persistence.Word
import com.android.luislenes.roomwordsample.persistence.WordRepository
import javax.inject.Inject

class MainViewModel : ViewModel() {

    @Inject
    lateinit var repository: WordRepository
    private val _allWords: LiveData<List<Word>>
    val allWords get() = _allWords

    init {
        WordApplication.appComponent.inject(this)
        _allWords = repository.allWords
    }

    fun insert(word: Word) {
        repository.insert(word)
    }

    fun deleteAll() {
        repository.deleteAll()
    }

    fun delete(word: Word) {
        repository.delete(word)
    }
}