package com.example.navigationfragapp.model
import java.io.Serializable


data class Event (
    val name: String,
    val category: String,
    val date: String,
) : Serializable