package com.example.navigationfragapp.adapter

import com.example.navigationfragapp.model.Event

interface ClickHandler {
    fun onEventItemClick(event: Event)
}