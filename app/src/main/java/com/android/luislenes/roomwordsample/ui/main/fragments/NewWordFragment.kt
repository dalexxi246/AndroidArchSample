package com.android.luislenes.roomwordsample.ui.main.fragments

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.luislenes.roomwordsample.R
import kotlinx.android.synthetic.main.fragment_new_word.*
import org.jetbrains.anko.support.v4.toast

class NewWordFragment : Fragment() {

    private var listener: NewWordListener? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_new_word, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        button_save.setOnClickListener {
            if (!TextUtils.isEmpty(edit_word.text)) {
                listener?.onSaveWord(edit_word.text.toString())
                fragmentManager?.beginTransaction()?.remove(this)?.commit()
            } else {
                toast(R.string.no_word_entered)
            }
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is NewWordListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement NewWordListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    interface NewWordListener {
        fun onSaveWord(word: String)
    }
}
