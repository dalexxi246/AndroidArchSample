package com.android.luislenes.roomwordsample.persistence

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*

@Dao
interface WordDao {

    @Insert
    fun insert(word: Word)

    @Query("DELETE FROM word_table")
    fun deleteAll()

    @Delete
    fun delete(word: Word)

    @Update
    fun update(word: Word)

    @Query("SELECT * FROM word_table ORDER BY word ASC")
    fun getAllWords() : LiveData<List<Word>>

}