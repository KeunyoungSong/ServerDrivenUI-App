package com.example.serverdrivenui.databinding.model.item

import com.example.serverdrivenui.databinding.model.ListItem
import com.example.serverdrivenui.databinding.model.ViewType

data class Image(
    val imageUrl: String
) : ListItem {
    override val viewType: ViewType
        get() = ViewType.IMAGE
}