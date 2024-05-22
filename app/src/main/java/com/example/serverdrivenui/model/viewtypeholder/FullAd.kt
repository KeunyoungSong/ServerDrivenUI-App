package com.example.serverdrivenui.model.viewtypeholder

import com.example.serverdrivenui.model.ListItem
import com.example.serverdrivenui.model.ViewType

data class FullAd(
    val title: String,
    val imageUrl: String,
    val button: String? = null
) : ListItem {
    override val viewType: ViewType
        get() = ViewType.FULL_AD
}