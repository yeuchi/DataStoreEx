package com.ctyeung.datastoreex.ui

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ctyeung.datastoreex.DataItem
import com.ctyeung.datastoreex.R
import java.lang.Exception

class ListFragment : Fragment() {

    private lateinit var model: ListViewModel
    private lateinit var recycler_view:RecyclerView
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
            recycler_view = root.findViewById<RecyclerView>(R.id.recycler_view)
            recycler_view.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        }
        return root
    }

    /*
     * replace with recursion or recyclerViews
     */
    private fun initListeners(editText: EditText) {
        /*
         * TODO consolidate this when working
         */

    }

    override fun onResume() {
        super.onResume()
        model.list.observe(this, Observer(::onChangeList) )
    }

    var updateData : (Int, Int) -> Unit = {
        index:Int,
        num:Int ->
        model.setDataItem(index, num)
    }

    private fun onChangeList(data: DataItem) {
        var list = data.numList.toMutableList()
        list.add(0)
        val adapter = ListAdapter(list, updateData)
        recycler_view.adapter = adapter
        recycler_view.hasFixedSize()
    }
}