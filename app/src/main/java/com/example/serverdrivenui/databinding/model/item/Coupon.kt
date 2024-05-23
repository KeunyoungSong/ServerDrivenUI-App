package com.example.serverdrivenui.databinding.model.item

import com.example.serverdrivenui.databinding.model.ListItem
import com.example.serverdrivenui.databinding.model.ViewType

data class Coupon(
    val imageUrl: String,
    val name: String,
    val coupon: String,
) : ListItem {
    override val viewType: ViewType
        get() = ViewType.COUPON
}