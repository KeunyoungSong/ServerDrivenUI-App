package com.example.serverdrivenui.databinding.model.item

import com.example.serverdrivenui.databinding.model.ListItem
import com.example.serverdrivenui.databinding.model.ViewType

data class Sale(
    val imageUrl: String,
    val sale: String,
    val name: String,
    val badge: String? = null
) : ListItem {
    override val viewType: ViewType
        get() = ViewType.SALE
}