package com.openclassrooms.notes.data

import java.io.Serializable

data class Note (
    val title: String,
    val body: String,
    val id: Int = 0
) : Serializable