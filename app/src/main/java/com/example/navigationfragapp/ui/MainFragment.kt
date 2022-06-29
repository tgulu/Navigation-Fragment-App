package com.example.navigationfragapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.navigationfragapp.R
import com.example.navigationfragapp.adapter.ClickHandler
import com.example.navigationfragapp.adapter.EventAdapter
import com.example.navigationfragapp.databinding.FragmentMainBinding
import com.example.navigationfragapp.model.Event

class MainFragment : Fragment(), ClickHandler {

    private var newEvent: Event? = null
    private var newAction: String? = null

    private val binding by lazy {
        FragmentMainBinding.inflate(layoutInflater)
    }

    private val eventAdapter by lazy {
        EventAdapter(this) { event ->
            findNavController().navigate(
                R.id.action_mainFragment_to_addFragment,
                bundleOf(Pair(AddFragment.EVENT_DATA, event))
            )
        }
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            newEvent = it.getSerializable(AddFragment.EVENT_DATA) as? Event
            newAction = it.getString("ACTION")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment.

        binding.todoRecycler.apply {
            layoutManager = LinearLayoutManager(
                requireContext(),
                LinearLayoutManager.VERTICAL,
                false)
            adapter = eventAdapter
        }

        binding.createEvent.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_entryFragment)
        }

        binding.todoRecycler.setOnClickListener {
            findNavController().navigate(R.id.action_EntryFragment_to_MainFragment)
        }

        return binding.root
    }

    override fun onResume() {
        super.onResume()

        newEvent?.let {
            eventAdapter.updateEventsList(it)
            newEvent = null
            arguments = null
        }
    }

    override fun onEventItemClick(event: Event) {
        findNavController().navigate(
            R.id.action_mainFragment_to_addFragment,
            bundleOf(Pair(AddFragment.EVENT_DATA, event))
        )
    }
}