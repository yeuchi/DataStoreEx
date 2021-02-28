package com.ctyeung.datastoreex.ui

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.ctyeung.datastoreex.DataItem
import com.ctyeung.datastoreex.R

class ListFragment : Fragment() {

    private lateinit var model: ListViewModel
    private lateinit var edit_text1:EditText
    private lateinit var edit_text2:EditText
    private lateinit var edit_text3:EditText
    private lateinit var edit_text4:EditText
    private lateinit var root:View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        model = ViewModelProvider(this).get(ListViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.fragment_list, container, false)

        root?.let {
            edit_text1 = root.findViewById(R.id.edit_text1)
            edit_text2 = root.findViewById(R.id.edit_text2)
            edit_text3 = root.findViewById(R.id.edit_text3)
            edit_text4 = root.findViewById(R.id.edit_text4)
            initListeners()
        }
        return root
    }

    private fun initListeners() {
        /*
         * TODO consolidate this when working
         */
        edit_text1.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {}
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                model.setDataItem(0, s.toString())
            }
        })
        edit_text2.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {}
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                model.setDataItem(1, s.toString())
            }
        })
        edit_text3.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {}
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                model.setDataItem(2, s.toString())
            }
        })
        edit_text4.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {}
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                model.setDataItem(3, s.toString())
            }
        })
    }

    override fun onResume() {
        super.onResume()
        model.list.observe(this, Observer(::onChangeList) )
    }

    private fun onChangeList(data: DataItem) {

    }
}