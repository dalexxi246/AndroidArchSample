package com.android.luislenes.roomwordsample.domain

import com.android.luislenes.roomwordsample.persistence.Word
import com.android.luislenes.roomwordsample.persistence.WordRepository
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class WordUseCaseImplTest {

    private lateinit var wordUseCaseImpl: WordUseCaseImpl

    private val wordRepository: WordRepository = mock()

    @Before
    fun setUp() {
        wordUseCaseImpl = WordUseCaseImpl(wordRepository)
    }

    @Test
    fun addWord() {

        // ARRANGE
        val word = Word("Test")

        // ACT
        runBlocking { wordUseCaseImpl.add(word) }

        // ASSERT
        verify(wordRepository).insert(word)

    }

    @Test
    fun deleteWord() {

        // ARRANGE
        val word = Word("Test")

        // ACT
        runBlocking { wordUseCaseImpl.delete(word) }

        // ASSERT
        verify(wordRepository).delete(word)

    }

    @Test
    fun deleteAllWords() {

        // ARRANGE

        // ACT
        runBlocking { wordUseCaseImpl.deleteAll() }

        // ASSERT
        verify(wordRepository).deleteAll()

    }

    @Test
    fun getAllWords() {
        // ARRANGE

        // ACT
        wordUseCaseImpl.getAllWords()

        // ASSERT
        verify(wordRepository).getAllWords()

    }
}