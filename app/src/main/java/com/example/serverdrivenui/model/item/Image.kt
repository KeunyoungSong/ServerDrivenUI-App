package com.example.serverdrivenui.model.item

import com.example.serverdrivenui.model.ListItem
import com.example.serverdrivenui.model.ViewType

data class Image(
    val imageUrl: String
) : ListItem {
    override val viewType: ViewType
        get() = ViewType.IMAGE
}