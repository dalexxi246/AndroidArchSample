package com.android.luislenes.roomwordsample.persistence

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "word_table")
class Word(@NotNull
           @PrimaryKey
           @ColumnInfo(name = "word") val mWord: String)