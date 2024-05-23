package com.example.serverdrivenui.databinding.model.item

import com.example.serverdrivenui.databinding.model.ListItem
import com.example.serverdrivenui.databinding.model.ViewType

data class SellItem(
    val imageUrl: String,
    val name: String,
    val price: Long,
    val badge: String? = null,
    val rating: Float? = null
) : ListItem {
    override val viewType: ViewType
        get() = ViewType.SELL_ITEM
}