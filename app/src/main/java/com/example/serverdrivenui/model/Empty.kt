package com.example.serverdrivenui.model

class Empty: ListItem {
    override val viewType: ViewType
        get() = ViewType.EMPTY
}