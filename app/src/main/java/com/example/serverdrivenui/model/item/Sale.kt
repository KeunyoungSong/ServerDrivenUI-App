package com.example.serverdrivenui.model.item

import com.example.serverdrivenui.model.ListItem
import com.example.serverdrivenui.model.ViewType

data class Sale(
    val imageUrl: String,
    val sale: String,
    val name: String,
    val badge: String? = null
) : ListItem {
    override val viewType: ViewType
        get() = ViewType.SALE
}