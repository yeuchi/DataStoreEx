package com.ctyeung.datastoreex.ui

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.ctyeung.datastoreex.Developer
import com.ctyeung.datastoreex.R

class ProtoFragment : Fragment() {

    private lateinit var model:ProtoViewModel
    private lateinit var root:View
    private lateinit var edit_name:EditText
    private lateinit var txt_name:TextView

    private lateinit var num_id:NumberPicker
    private lateinit var txt_id:TextView

    private lateinit var check_is_remote:CheckBox
    private lateinit var txt_is_remote:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        model = ViewModelProvider(this).get(ProtoViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.fragment_proto, container, false)

        root?.let {
            edit_name = it.findViewById(R.id.edit_name)
            txt_name = it.findViewById(R.id.txt_name)

            num_id = it.findViewById(R.id.num_id)
            txt_id = it.findViewById(R.id.txt_id)

            check_is_remote = it.findViewById(R.id.check_is_remote)
            txt_is_remote = it.findViewById(R.id.txt_is_remote)

            initListeners()
        }

        return root
    }

    private fun initListeners() {

        num_id.minValue = 0
        num_id.maxValue = 10
        num_id.setOnValueChangedListener { picker, oldVal, newVal ->
            model.setDev(newVal)
        }

        check_is_remote.setOnCheckedChangeListener { buttonView, isChecked ->
            model.setDev(isChecked)
        }

        edit_name.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                model.setDev(s.toString())
            }
        })
    }

    override fun onResume() {
        super.onResume()
        model.protoDev.observe(this, Observer(::onChangeDev))
    }

    private fun onChangeDev(dev:Developer){
        txt_name.text = dev.name
        txt_id.text = dev.id.toString()
        txt_is_remote.text = if(dev.isRemote){"true"} else {"false"}
    }
}