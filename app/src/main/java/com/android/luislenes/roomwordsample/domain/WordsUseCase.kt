package com.android.luislenes.roomwordsample.domain

import android.arch.lifecycle.LiveData
import com.android.luislenes.roomwordsample.persistence.Word
import com.android.luislenes.roomwordsample.persistence.WordRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

interface WordsUseCase {
    fun add(word: Word)
    fun deleteAll()
    fun delete(word: Word)
    fun getAllWords() : LiveData<List<Word>>
}

class WordUseCaseImpl(private val wordRepository: WordRepository) : WordsUseCase {

    override fun add(word: Word) {
        CoroutineScope(Dispatchers.IO).launch  {
            wordRepository.insert(word)
        }
    }

    override fun deleteAll() {
        CoroutineScope(Dispatchers.IO).launch  {
            wordRepository.deleteAll()
        }
    }

    override fun delete(word: Word) {
        CoroutineScope(Dispatchers.IO).launch {
            wordRepository.delete(word)
        }
    }

    override fun getAllWords() : LiveData<List<Word>> {
        return wordRepository.getAllWords()
    }
}