package com.example.navigationfragapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.navigationfragapp.R
import com.example.navigationfragapp.databinding.FragmentDetailsBinding
import com.example.navigationfragapp.model.Event


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class DetailsFragment : Fragment() {

    private val binding by lazy { FragmentDetailsBinding.inflate(layoutInflater) }
    private var selectedEvent : Event ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            selectedEvent = it.getSerializable("EventDetail") as Event?
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
/*
        binding.savEventbtn.setOnClickListener {
            findNavController().navigate(R.id.action_DetailsToItemListFragment, bundleOf(
                Pair("DoneEvent", selectedEvent)
            )
            )
        }

*/

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_details, container, false)
    }



    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            DetailsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }


}