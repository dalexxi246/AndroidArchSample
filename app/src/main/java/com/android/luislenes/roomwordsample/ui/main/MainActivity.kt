package com.android.luislenes.roomwordsample.ui.main

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.helper.ItemTouchHelper
import android.view.Menu
import android.view.MenuItem
import com.android.luislenes.roomwordsample.R
import com.android.luislenes.roomwordsample.persistence.Word
import com.android.luislenes.roomwordsample.ui.adapters.WordListAdapter
import com.android.luislenes.roomwordsample.ui.main.fragments.NewWordFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import org.jetbrains.anko.toast


class MainActivity : AppCompatActivity(), NewWordFragment.NewWordListener {

    lateinit var mainViewModel: MainViewModel
    lateinit var wordListAdapter: WordListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        setUpRecyclerView()
        setUpViewModel()
        setUpListeners()
    }

    private fun setUpListeners() {
        fab.setOnClickListener {
            supportFragmentManager.beginTransaction().add(R.id.content_main, NewWordFragment()).commit()
        }
    }

    private fun setUpViewModel() {
        mainViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        mainViewModel.allWords.observe(this, Observer {
            wordListAdapter.words = it
        })
    }

    private fun setUpRecyclerView(): WordListAdapter {
        wordListAdapter = WordListAdapter(this)
        recyclerview.adapter = wordListAdapter
        recyclerview.layoutManager = LinearLayoutManager(this)
        attachRecyclerViewToItemTouchHelper(recyclerview)
        return wordListAdapter
    }

    private fun attachRecyclerViewToItemTouchHelper(recyclerView: RecyclerView) {
        val itemTouchHelper = ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(
                0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT
        ) {
            override fun onMove(rc: RecyclerView, rcViewHolder: RecyclerView.ViewHolder, rcViewHolderTarget: RecyclerView.ViewHolder): Boolean {
                return false
            }

            override fun onSwiped(rcViewHolder: RecyclerView.ViewHolder, direction: Int) {
                val word = wordListAdapter.getWordAtPosition(rcViewHolder.adapterPosition)
                toast("${getString(R.string.deleting_word)} ${word!!.mWord}")
                mainViewModel.delete(word)
            }

        })
        itemTouchHelper.attachToRecyclerView(recyclerView)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.clear_data -> {
                toast(R.string.cleaning_data)
                mainViewModel.deleteAll()
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onSaveWord(word: String) {
        mainViewModel.insert(Word(word))
    }
}
