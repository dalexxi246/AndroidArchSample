package com.android.luislenes.roomwordsample.persistence

import android.arch.lifecycle.LiveData
import com.android.luislenes.roomwordsample.WordApplication
import org.jetbrains.anko.doAsync
import javax.inject.Inject

class WordRepository {

    @Inject
    lateinit var appDatabase: AppDatabase
    private val dao: WordDao
    private val _allWords: LiveData<List<Word>>
    val allWords get() = _allWords

    init {
        WordApplication.appComponent.inject(this)
        dao = appDatabase.wordDao()
        _allWords = dao.getAllWords()
    }

    fun insert(word: Word) {
        doAsync {
            dao.insert(word)
        }
    }

    fun deleteAll() {
        doAsync {
            dao.deleteAll()
        }
    }

    fun delete(word: Word) {
        doAsync {
            dao.delete(word)
        }
    }
}