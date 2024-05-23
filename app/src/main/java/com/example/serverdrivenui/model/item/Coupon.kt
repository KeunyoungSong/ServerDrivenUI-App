package com.example.serverdrivenui.model.item

import com.example.serverdrivenui.model.ListItem
import com.example.serverdrivenui.model.ViewType

data class Coupon(
    val imageUrl: String,
    val name: String,
    val coupon: String,
) : ListItem {
    override val viewType: ViewType
        get() = ViewType.COUPON
}