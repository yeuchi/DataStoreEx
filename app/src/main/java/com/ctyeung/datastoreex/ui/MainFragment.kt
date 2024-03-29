package com.ctyeung.datastoreex.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.ctyeung.datastoreex.R

class MainFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btn_pref = activity?.findViewById(R.id.btn_preference) as Button
        btn_pref?.apply {
            setOnClickListener{
                findNavController().navigate(R.id.action_mainFragment_to_preferenceFragment)
            }
        }

        val btn_proto = activity?.findViewById(R.id.btn_proto) as Button
        btn_proto?.apply {
            setOnClickListener{
                findNavController().navigate(R.id.action_mainFragment_to_protoFragment)
            }
        }

        val btn_list = activity?.findViewById(R.id.btn_list) as Button
        btn_list?.apply {
            setOnClickListener{
                findNavController().navigate(R.id.action_mainFragment_to_listFragment)
            }
        }

        val btn_map = activity?.findViewById(R.id.btn_map) as Button
        btn_map?.apply {
            setOnClickListener{
                findNavController().navigate(R.id.action_mainFragment_to_mapFragment)
            }
        }
    }
}