package com.example.serverdrivenui.model

import java.io.Serializable

interface ListItem : Serializable {
    val viewType: ViewType

    fun getKey() = hashCode()
}

enum class ViewType {
    VIEW_PAGER,
    HORIZONTAL,
    FULL_AD,
    EMPTY,

    SELL_ITEM,
    IMAGE,
    SALE,
    COUPON,
}