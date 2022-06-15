package com.example.navigationfragapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.navigationfragapp.databinding.TodoItemBinding
import com.example.navigationfragapp.model.Event

class EventAdapter(
    private val eventsList: MutableList<Event> = mutableListOf()
)
    : RecyclerView.Adapter<EventViewHolder>() {
    fun updateEventList(event: Event){
        eventsList.add(event)
        notifyDataSetChanged()
        //notifyItemInserted(eventsList.indexOf(event))

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder =
        EventViewHolder(
            TodoItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )


    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        holder.bind(eventsList[position])
    }

    override fun getItemCount(): Int = eventsList.size
    }


    class EventViewHolder(
        private val binding: TodoItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(event: Event) {
            binding.eventName.text = event.name
            binding.eventCategory.text = event.category
            binding.eventDate.text = event.data

        }
    }


