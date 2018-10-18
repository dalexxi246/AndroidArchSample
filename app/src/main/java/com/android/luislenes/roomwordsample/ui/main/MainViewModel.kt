package com.android.luislenes.roomwordsample.ui.main

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.android.luislenes.roomwordsample.WordApplication
import com.android.luislenes.roomwordsample.domain.WordsUseCase
import com.android.luislenes.roomwordsample.persistence.Word
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val wordsUseCase: WordsUseCase) : ViewModel() {

    fun getWords(): LiveData<List<Word>> {
        return wordsUseCase.getAllWords()
    }

    fun insert(word: Word) {
        CoroutineScope(Dispatchers.Main).launch {
            wordsUseCase.add(word)
        }
    }

    fun deleteAll() {
        CoroutineScope(Dispatchers.Main).launch {
            wordsUseCase.deleteAll()
        }
    }

    fun delete(word: Word) {
        CoroutineScope(Dispatchers.Main).launch {
            wordsUseCase.delete(word)
        }
    }

    class Factory : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            val wordsUseCase = WordApplication.app.getWordsComponent().wordsUseCase()
            return MainViewModel(wordsUseCase) as T
        }
    }
}