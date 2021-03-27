package com.ctyeung.datastoreex.ui

import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ctyeung.datastoreex.R
import java.lang.Exception

class MapAdapter : RecyclerView.Adapter<MapAdapter.MapViewHolder> {

    private val map:MutableMap<String, String>
    private var index:Int = 0
    private val update:(String, String) -> Unit

    constructor(map:MutableMap<String, String>, update:(String, String) -> Unit) {
        this.map = map
        this.update = update
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MapViewHolder {
        var inflater = LayoutInflater.from(parent.context)
        var view = inflater.inflate(R.layout.string_tile, parent, false)
        val keys = this.map.keys
        var holder = MapViewHolder(view, index, keys, this.map, update)
        index ++
        return holder
    }

    override fun onBindViewHolder(holder: MapViewHolder, position: Int) {
    }

    override fun getItemCount(): Int {
        return map.size
    }

    class MapViewHolder : RecyclerView.ViewHolder, View.OnClickListener {

        private val txt_index: TextView
        private val txt_read: TextView
        private val edit_text: EditText
        private val index:Int
        private val update:(String, String) -> Unit

        constructor(itemView: View,
                    i:Int,
                    keys:MutableSet<String>,
                    map:MutableMap<String, String>,
                    update:(String, String) -> Unit) : super(itemView) {
            this.index = i
            this.update = update

            txt_index = itemView.findViewById<TextView>(R.id.txt_index)
            txt_index.text = i.toString()

            val key = keys.elementAt(i)
            val value = map[key]
            edit_text = itemView.findViewById<EditText>(R.id.edit_text)
            edit_text.setText(value)

            edit_text.addTextChangedListener(object : TextWatcher {
                override fun afterTextChanged(s: Editable?) {}
                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    var str:String = "empty"
                    try{
                        str = s.toString()
                        update(key, str)
                    }
                    catch (ex: Exception){

                    }
                }
            })

            txt_read = itemView.findViewById<TextView>(R.id.txt_read)
            txt_read.text = value
        }

        override fun onClick(p0: View?) {

        }
    }
}