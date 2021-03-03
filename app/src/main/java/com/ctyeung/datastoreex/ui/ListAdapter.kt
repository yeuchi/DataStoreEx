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

class ListAdapter: RecyclerView.Adapter<ListAdapter.ListViewHolder> {

    private val numbers:List<Int>
    private var index:Int = 0
    private val update:(Int, Int) -> Unit

    constructor(numbers:List<Int>, update:(Int, Int) -> Unit) {
        this.numbers = numbers
        this.update = update
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        var inflater = LayoutInflater.from(parent.context)
        var view = inflater.inflate(R.layout.tile, parent, false)
        val num = this.numbers[index]
        var holder = ListViewHolder(view, index, num, update)
        index ++
        return holder
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
    }

    override fun getItemCount(): Int {
        return numbers.size
    }

    class ListViewHolder : RecyclerView.ViewHolder, View.OnClickListener {

        private val txt_index:TextView
        private val txt_read:TextView
        private val edit_text:EditText
        private val index:Int
        private val update:(Int, Int) -> Unit

        constructor(itemView: View, i:Int, number:Int, update:(Int, Int) -> Unit) : super(itemView) {
            this.index = i
            this.update = update

            txt_index = itemView.findViewById<TextView>(R.id.txt_index)
            txt_index.text = i.toString()

            edit_text = itemView.findViewById<EditText>(R.id.edit_text)
            edit_text.setText(number.toString())

            edit_text.addTextChangedListener(object : TextWatcher {
                override fun afterTextChanged(s: Editable?) {}
                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    var num = 0
                    try{
                        num = s.toString().toInt()
                        update(index, num)
                    }
                    catch (ex: Exception){

                    }
                }
            })

            txt_read = itemView.findViewById<TextView>(R.id.txt_read)
            txt_read.text = number.toString()
        }

        override fun onClick(p0: View?) {

        }
    }
}

