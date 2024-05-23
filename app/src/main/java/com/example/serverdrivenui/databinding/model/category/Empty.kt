package com.example.serverdrivenui.databinding.model.category

import com.example.serverdrivenui.databinding.model.ListItem
import com.example.serverdrivenui.databinding.model.ViewType

class Empty: ListItem {
    override val viewType: ViewType
        get() = ViewType.EMPTY
}