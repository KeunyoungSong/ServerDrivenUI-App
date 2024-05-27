package com.example.serverdrivenui.model.category

import com.example.serverdrivenui.model.ListItem
import com.example.serverdrivenui.model.ViewType

class Empty: ListItem {
    override val viewType: ViewType
        get() = ViewType.EMPTY
}