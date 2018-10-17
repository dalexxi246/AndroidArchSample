package com.android.luislenes.roomwordsample.ui.main

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.android.luislenes.roomwordsample.WordApplication
import com.android.luislenes.roomwordsample.domain.WordsUseCase
import com.android.luislenes.roomwordsample.persistence.Word

class MainViewModel(private val wordsUseCase: WordsUseCase) : ViewModel() {

    fun getWords(): LiveData<List<Word>> {
        return wordsUseCase.getAllWords()
    }

    fun insert(word: Word) {
        wordsUseCase.add(word)
    }

    fun deleteAll() {
        wordsUseCase.deleteAll()
    }

    fun delete(word: Word) {
        wordsUseCase.delete(word)
    }

    class Factory : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            val wordsUseCase = WordApplication.app.getWordsComponent().wordsUseCase()
            return MainViewModel(wordsUseCase) as T
        }
    }
}