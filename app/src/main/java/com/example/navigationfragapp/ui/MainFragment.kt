package com.example.navigationfragapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import com.example.navigationfragapp.databinding.FragmentMainBinding
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.navigationfragapp.R
import com.example.navigationfragapp.adapter.EventAdapter


class MainFragment : Fragment() {


    private val binding by lazy {
        FragmentMainBinding.inflate(layoutInflater)
    }
    private val eventAdapter by lazy {
        EventAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

    binding.todoRecyler.apply {
        layoutManager = LinearLayoutManager(
            requireContext(),
            LinearLayoutManager.VERTICAL,
            false)
        adapter =  eventAdapter
    }
        return binding.root
    }


}


