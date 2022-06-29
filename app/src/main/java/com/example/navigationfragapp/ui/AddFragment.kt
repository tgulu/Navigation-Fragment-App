package com.example.navigationfragapp.ui

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.navigationfragapp.R
import com.example.navigationfragapp.databinding.FragmentEntryBinding
import com.example.navigationfragapp.model.Event
import java.text.SimpleDateFormat

class AddFragment : Fragment() {

    private val binding by lazy {
        FragmentEntryBinding.inflate(layoutInflater)
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment

        binding.eventNameEntry.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                binding.saveEventBtn.isEnabled = p0?.isNotEmpty() ?: false
            }

            override fun afterTextChanged(p0: Editable?) {

            }

        })

        binding.saveEventBtn.setOnClickListener {
            val name = binding.eventNameEntry.text.toString()
            val category = binding.eventCategoryEntry.text.toString()
            //val dt = binding.calendarEvent.date.toString()
            //val date = dateToString(longToDate(currentItem.dt))

            val SimpleF = SimpleDateFormat("MM/dd/yyyy")
            var date: String
            binding.calendarEvent.setOnDateChangeListener{view,year,month,dayOfMonth ->
                date = "${month+1}/$dayOfMonth/$year"
            }.let {
                date = SimpleF.format(binding.calendarEvent.date)
            }

            Event(name, category, date).also {
                findNavController().navigate(R.id.action_EntryFragment_to_MainFragment, bundleOf(
                    Pair(EVENT_DATA, it)
                ))
            }
        }

        return binding.root
    }



    companion object {
        const val EVENT_DATA = "EVENT_DATA"
    }
}