package com.example.navigationfragapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.navigationfragapp.databinding.TodoItemBinding
import com.example.navigationfragapp.model.Event

class EventAdapter(
    // clock handling with interface
    private val onEventClickHandler: ClickHandler,
    private val eventsList: MutableList<Event> = mutableListOf(),

    // click handling with high order function
    private val onClickEventHighOrderFunction: (Event) -> Unit
) : RecyclerView.Adapter<EventViewHolder>() {

    fun updateEventsList(event: Event) {
        eventsList.add(event)
        notifyItemInserted(eventsList.indexOf(event))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder =
        EventViewHolder(
            TodoItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) =
        holder.bind(eventsList[position], onEventClickHandler, onClickEventHighOrderFunction)

    override fun getItemCount(): Int = eventsList.size
}

class EventViewHolder(
    private val binding: TodoItemBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(event: Event, onEventClickHandler: ClickHandler, onClickEventHighOrderFunction: (Event) -> Unit) {
        binding.eventName.text = event.name
        binding.eventCategory.text = event.category
        binding.eventDate.text = event.date

    }
}