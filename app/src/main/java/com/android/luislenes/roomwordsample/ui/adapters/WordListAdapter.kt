package com.android.luislenes.roomwordsample.ui.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.android.luislenes.roomwordsample.R
import com.android.luislenes.roomwordsample.persistence.Word
import org.jetbrains.anko.find

class WordListAdapter(private val context: Context) : RecyclerView.Adapter<WordViewHolder>(){

    var words: List<Word>? = null
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        return WordViewHolder(LayoutInflater.from(context).inflate(R.layout.recyclerview_item, parent, false))
    }

    override fun getItemCount(): Int {
        return words?.size ?: 0
    }

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        holder.wordTextView.text = words?.get(position)?.mWord ?: "No Word" 
    }

    fun getWordAtPosition(position: Int): Word? {
        return words?.get(position)
    }
}

class WordViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val wordTextView: TextView = itemView.find(R.id.textView)

}