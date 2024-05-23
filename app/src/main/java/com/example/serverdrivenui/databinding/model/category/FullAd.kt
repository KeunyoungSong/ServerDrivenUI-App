package com.example.serverdrivenui.databinding.model.category

import com.example.serverdrivenui.databinding.model.ListItem
import com.example.serverdrivenui.databinding.model.ViewType

data class FullAd(
    val title: String,
    val imageUrl: String,
    val button: String? = null
) : ListItem {
    override val viewType: ViewType
        get() = ViewType.FULL_AD
}