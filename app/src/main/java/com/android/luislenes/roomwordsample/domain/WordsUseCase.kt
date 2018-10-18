package com.android.luislenes.roomwordsample.domain

import android.arch.lifecycle.LiveData
import com.android.luislenes.roomwordsample.persistence.Word
import com.android.luislenes.roomwordsample.persistence.WordRepository

interface WordsUseCase {
    suspend fun add(word: Word)
    suspend fun deleteAll()
    suspend fun delete(word: Word)
    fun getAllWords() : LiveData<List<Word>>
}

class WordUseCaseImpl(private val wordRepository: WordRepository) : WordsUseCase {

    override suspend fun add(word: Word) {
        wordRepository.insert(word)
    }

    override suspend fun deleteAll() {
        wordRepository.deleteAll()
    }

    override suspend fun delete(word: Word) {
        wordRepository.delete(word)
    }

    override fun getAllWords() : LiveData<List<Word>> {
        return wordRepository.getAllWords()
    }
}