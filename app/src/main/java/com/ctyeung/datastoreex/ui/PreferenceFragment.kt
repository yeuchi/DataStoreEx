package com.ctyeung.datastoreex.ui

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.ctyeung.datastoreex.R

class PreferenceFragment : Fragment() {

    private lateinit var model: PreferenceViewModel
    private lateinit var rdoGroup:RadioGroup
    private lateinit var root:View
    private lateinit var editText: EditText
    private lateinit var txtString:TextView
    private lateinit var txtBoolean: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        model = ViewModelProvider(this).get(PreferenceViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.fragment_preference, container, false)

        root?.let {
            rdoGroup = it.findViewById(R.id.rdo_group)
            txtBoolean = root.findViewById(R.id.txt_boolean)

            editText = root.findViewById(R.id.edit_string)
            txtString = root.findViewById(R.id.txt_string)

            initListeners()
        }

        return root
    }

    private fun initListeners() {
        rdoGroup.setOnCheckedChangeListener(
            RadioGroup.OnCheckedChangeListener { group, checkedId ->
                var btn = root.findViewById(checkedId) as RadioButton
                btn.isChecked = true
                when(btn.id) {
                    R.id.rdo1 -> model.setPrefBoolean(true)
                    R.id.rdo2 -> model.setPrefBoolean(false)
                }
            })

        editText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                model.setPrefString(s.toString())
            }
        })
    }

    override fun onResume() {
        super.onResume()
        model.prefBoolean.observe(this, Observer(::onChangeBoolean) )
        model.prefString.observe(this, Observer(::onChangeString) )
    }

    private fun onChangeBoolean(flag:Boolean) {
        txtBoolean.text = if(flag){"true"} else {"false"}
    }

    private fun onChangeString(str:String) {
        txtString.text = str
    }
}