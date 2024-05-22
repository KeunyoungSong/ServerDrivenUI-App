package com.example.serverdrivenui.model.viewtypeholder

import com.example.serverdrivenui.model.ListItem
import com.example.serverdrivenui.model.ViewType

class Empty: ListItem {
    override val viewType: ViewType
        get() = ViewType.EMPTY
}