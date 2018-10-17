package com.android.luislenes.roomwordsample.persistence

import android.arch.lifecycle.LiveData

interface WordRepository {
    fun insert(word: Word)
    fun deleteAll()
    fun delete(word: Word)
    fun getAllWords() : LiveData<List<Word>>
}

class RoomWordRepository(appDatabase: AppDatabase) : WordRepository {

    private val dao: WordDao = appDatabase.wordDao()

    override fun getAllWords() : LiveData<List<Word>> {
        return dao.getAllWords()
    }

    override fun insert(word: Word) {
        dao.insert(word)
    }

    override fun deleteAll() {
        dao.deleteAll()
    }

    override fun delete(word: Word) {
        dao.delete(word)
    }
}