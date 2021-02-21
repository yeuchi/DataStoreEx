package com.ctyeung.datastoreex.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.ctyeung.datastoreex.R

class PreferenceFragment : Fragment() {

    private lateinit var model: PreferenceViewModel
    private lateinit var rdoGroup:RadioGroup
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
        val view = inflater.inflate(R.layout.fragment_preference, container, false)
        rdoGroup = view.findViewById(R.id.rdo_group)
        txtBoolean = view.findViewById(R.id.txt_boolean)

        editText = view.findViewById(R.id.edit_string)
        txtString = view.findViewById(R.id.txt_string)
        return view
    }

    override fun onResume() {
        super.onResume()
        model.prefBoolean.observe(this, Observer(::onChangeBoolean) )
    }

    private fun onChangeBoolean(flag:Boolean) {
        txtBoolean.text = if(flag){"true"} else {"false"}
    }

    private fun onChangeString(str:String) {
        txtString.text = str
    }
}