package com.ctyeung.datastoreex.ui

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.annotation.RequiresApi
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ctyeung.datastoreex.R
import com.ctyeung.datastoreex.Record
import java.time.ZonedDateTime
import java.time.ZonedDateTime.now

class MapFragment : Fragment() {

    private lateinit var model: MapViewModel
    private lateinit var recycler_view: RecyclerView
    private lateinit var root:View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        model = ViewModelProvider(this).get(MapViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.fragment_map, container, false)
        root?.let {
            recycler_view = root.findViewById<RecyclerView>(R.id.recycler_view)
            recycler_view.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        }
        return root
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.btn_add).setOnClickListener {
            val time = ZonedDateTime.now()
            updateData(time.toString(), "hello")
        }
    }

    override fun onResume() {
        super.onResume()
        model.map.observe(this, Observer(::onChangeMap) )
    }

    var updateData : (String, String) -> Unit = {
        key:String,
        value:String ->
        model.setRecord(key, value)
    }

    private fun onChangeMap(record:Record) {
        var map = record.hashMap.toMutableMap()
        val adapter = MapAdapter(map, updateData)
        recycler_view.adapter = adapter
        recycler_view.hasFixedSize()
    }
}