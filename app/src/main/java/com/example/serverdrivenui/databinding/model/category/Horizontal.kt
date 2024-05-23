package com.example.serverdrivenui.databinding.model.category

import com.example.serverdrivenui.databinding.model.ListItem
import com.example.serverdrivenui.databinding.model.ViewType

data class Horizontal(
    val title: String,
    val items: List<ListItem>
) : ListItem {
    override val viewType: ViewType
        get() = ViewType.HORIZONTAL
}